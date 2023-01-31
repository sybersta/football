package com.example.football.service.impl;

import com.example.football.Util.MatchUtil;
import com.example.football.Util.MyJSErrorListener;
import com.example.football.Util.MyJavaScriptEngine;
import com.example.football.Util.WeixinRoket;
import com.example.football.dao.MongoGoalLineRecommandRepository;
import com.example.football.dao.MongoHandicapRecommandRepository;
import com.example.football.dao.MongoRaceRepository;
import com.example.football.dao.MongoWinDrawRecommandRepository;
import com.example.football.entity.GoalLineEntity;
import com.example.football.entity.HandicapEntity;
import com.example.football.entity.MongoEntity.*;
import com.example.football.entity.SimilarGameEntity;
import com.example.football.service.RecommandService;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.brotli.dec.BrotliInputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RecommandServiceImpl implements RecommandService {
    private static String ip = "192.168.10.24";
    private List<String> raceIdList=new ArrayList<String>();
    private long compareTime=0L;
    private long currentTime=0L;
    List<Integer> smallTimeList;
    List<Integer> bigTimeList;
    @Autowired
    private MongoRaceRepository mongoRaceRepository;
    @Autowired
    private MongoGoalLineRecommandRepository mongoGoalLineRecommandRepository;
    @Autowired
    private MongoWinDrawRecommandRepository mongoWinDrawRecommandRepository;
    @Autowired
    private MongoHandicapRecommandRepository mongoHandicapRecommandRepository;


    @Override
    public void startScann() throws Exception{
        System.out.println("start scan");
              WebClient webClient =null;
                      compareTime=new Date().getTime();
              while(true){
                  try{
                      webClient=new WebClient(BrowserVersion.CHROME);
                  Elements allOnGames = getAllOnGames(webClient);
                  if(allOnGames != null && allOnGames.size() > 0) {
                      Iterator c = allOnGames.iterator();

                      while(c.hasNext()) {
                          Element teamWork = (Element)c.next();
                          BaseInfoEntity m=null;
                          try{
                              m= getBasicInfomation1(teamWork);
                              if(m==null){
                                  continue;
                              }
                              String str=m.getLeagueName()+"》"+m.getHomeTeamName()+"vs"+m.getVisitingTeamName()+"**"+m.getHandicap()+"\n";
                              if(m.getSimilarList()!=null&&m.getSimilarList().size()>0){
                                  for(SimilarGameEntity s:m.getSimilarList()){
                                      str+=s.getGameName()+"》"+s.getTime()+"》"+s.getHomeTeamName()+s.getScore()+
                                              s.getGuestTeamName()+"\n";

                                  }
                                  new WeixinRoket().sendMessage(str);
                                 raceIdList.add(m.getRaceId());
                              }

                          }catch(Exception e){
                              e.printStackTrace();
                          }
                      }
                  }
                  else{
                    continue;
                  }
                  Thread.sleep(1000*5*60);
                  currentTime=new Date().getTime();
                  long hour = (currentTime - compareTime) / 1000 / 3600;
                  if(hour>20L){
                      raceIdList=new ArrayList<String>();
                      compareTime=new Date().getTime();
                  }}catch (Exception e){
                      e.printStackTrace();
                  }finally {
                      webClient.getCookieManager().clearCookies();
                      webClient.close();
                  }
              }
    }

    @Override
    public List<MongoRaceEntity> findAll() {
        return mongoRaceRepository.findAll();
    }

    public HashMap<String,Object> AnalysisHandicap(BaseInfoEntity m) {
        MongoGoalLineEntity entity1=null;
        MongoHandicapEntity entity2=null;
        MongoGoalLineEntity entity3=null;
        MongoHandicapEntity entity4=null;
        HashMap<String,Object> map=new HashMap<String,Object>();
        if(m.getGoalLineList()==null||m.getGoalLineList().size()==0){
            return null;
        }
        for(MongoGoalLineEntity mo:m.getGoalLineList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("6")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getLowerOdds()!=null&&mo.getUpperOdds()!=null&&
                    mo.getGoalLine()!=null){
                entity1=mo;
                break;
            }
        }
        for(MongoHandicapEntity mo:m.getHandicapList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("42")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getHomeOdds()!=null&&mo.getVisitingOdds()!=null&&
                    mo.getHandicap()!=null){
                entity2=mo;
                break;
            }
        }
        for(MongoHandicapEntity mo:m.getHandicapList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("6")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getHomeOdds()!=null&&mo.getVisitingOdds()!=null&&
                    mo.getHandicap()!=null){
                entity4=mo;
                break;
            }
        }
        for(MongoGoalLineEntity mo:m.getGoalLineList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("42")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getLowerOdds()!=null&&mo.getUpperOdds()!=null&&
                    mo.getGoalLine()!=null){
                entity3=mo;
                break;
            }
        }
        if(entity1!=null&&entity2!=null&&entity3!=null){
            List<MongoRaceEntity> list=  mongoRaceRepository.findHandicapList(
                    entity1.getTimeSeq(),entity1.getVisitingGoal(),entity1.getHomeGoal(),
                    entity1.getLowerOdds(),entity1.getUpperOdds(),entity1.getGoalLine(),
                    entity2.getTimeSeq(),entity2.getVisitingGoal(),entity2.getHomeGoal(),
                    entity2.getHomeOdds(),entity2.getVisitingOdds(), entity2.getHandicap(),
                    entity4.getTimeSeq(),entity4.getVisitingGoal(),entity4.getHomeGoal(),
                    entity4.getHomeOdds(),entity4.getVisitingOdds(), entity4.getHandicap(),
                    entity3.getTimeSeq(),entity3.getVisitingGoal(),entity3.getHomeGoal(),
                    entity3.getLowerOdds(),entity3.getUpperOdds(),entity3.getGoalLine());
            if(list==null||list.size()==0){
                return null;
            }else{
                List<SimpleRaceEntity> simple=new ArrayList<>();
                for(SimpleRaceEntity e:list){
                    simple.add(e);
                }
                map.put("entity",entity2);
                map.put("list",simple);
                return map;
            }
        }
        return null;
    }

    public HashMap<String,Object> AnalysisGoalLine(BaseInfoEntity m) {
        MongoGoalLineEntity entity1=null;
        MongoHandicapEntity entity2=null;
        MongoGoalLineEntity entity3=null;
        MongoHandicapEntity entity4=null;
        HashMap<String,Object> map=new HashMap<String,Object>();
        if(m.getGoalLineList()==null||m.getGoalLineList().size()==0){
            return null;
        }
        for(MongoGoalLineEntity mo:m.getGoalLineList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("6")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getLowerOdds()!=null&&mo.getUpperOdds()!=null&&
                    mo.getGoalLine()!=null){
                entity1=mo;
                break;
            }
        }
        for(MongoHandicapEntity mo:m.getHandicapList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("42")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getHomeOdds()!=null&&mo.getVisitingOdds()!=null&&
                    mo.getHandicap()!=null){
                entity2=mo;
                break;
            }
        }
        for(MongoHandicapEntity mo:m.getHandicapList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("6")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getHomeOdds()!=null&&mo.getVisitingOdds()!=null&&
                    mo.getHandicap()!=null){
                entity4=mo;
                break;
            }
        }
        for(MongoGoalLineEntity mo:m.getGoalLineList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("42")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getLowerOdds()!=null&&mo.getUpperOdds()!=null&&
                    mo.getGoalLine()!=null){
                entity3=mo;
                break;
            }
        }
        if(entity1!=null&&entity2!=null&&entity3!=null){
         List<MongoRaceEntity> list=  mongoRaceRepository.findGoalLineList(
                 entity1.getTimeSeq(),entity1.getVisitingGoal(),entity1.getHomeGoal(),
                 entity1.getLowerOdds(),entity1.getUpperOdds(),entity1.getGoalLine(),
                 entity2.getTimeSeq(),entity2.getVisitingGoal(),entity2.getHomeGoal(),
                 entity2.getHomeOdds(),entity2.getVisitingOdds(), entity2.getHandicap(),
                 entity4.getTimeSeq(),entity4.getVisitingGoal(),entity4.getHomeGoal(),
                 entity4.getHomeOdds(),entity4.getVisitingOdds(), entity4.getHandicap(),
                 entity3.getTimeSeq(),entity3.getVisitingGoal(),entity3.getHomeGoal(),
                 entity3.getLowerOdds(),entity3.getUpperOdds(),entity3.getGoalLine());
            if(list==null||list.size()==0){
                return null;
            }else{
                List<SimpleRaceEntity> simple=new ArrayList<>();
                for(SimpleRaceEntity e:list){
                    simple.add(e);
                }
                map.put("entity",entity3);
                map.put("list",simple);
                return map;
            }
        }
        return null;
    }

    public HashMap<String,Object> AnalysisWinDrawLost(BaseInfoEntity m) {
        MongoWinDrawEntity entity1 =null;
        MongoWinDrawEntity entity2 =null;
        HashMap<String,Object> map=new HashMap<>();
        if(m.getMongoWinDrawList()==null||m.getMongoWinDrawList().size()==0){
            return null;
        }
        for(MongoWinDrawEntity mo:m.getMongoWinDrawList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("6")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getWinOdds()!=null&&mo.getDrawOdds()!=null&&
                    mo.getLostOdds()!=null){
                entity1=mo;
                break;
            }
        }
        for(MongoWinDrawEntity mo:m.getMongoWinDrawList()){
            if(mo.getTimeSeq()!=null&&mo.getTimeSeq().contains("42")&&
                    mo.getHomeGoal()!=null&&mo.getVisitingGoal()!=null&&
                    mo.getWinOdds()!=null&&mo.getDrawOdds()!=null&&
                    mo.getLostOdds()!=null){
                entity2=mo;
                break;
            }
        }
        if(entity1!=null&&entity2!=null){
           List<MongoRaceEntity>list= mongoRaceRepository.findWinDrawList(
                   entity1.getTimeSeq(),entity1.getVisitingGoal(),entity1.getHomeGoal(),
                   entity1.getWinOdds(),entity1.getDrawOdds(),entity1.getLostOdds(),
                   entity2.getTimeSeq(),entity2.getVisitingGoal(),entity2.getHomeGoal(),
                   entity2.getWinOdds(),entity2.getDrawOdds(),entity2.getLostOdds());
            if(list==null||list.size()==0){
                return null;
            }else{
                List<SimpleRaceEntity> simple=new ArrayList<>();
                for(SimpleRaceEntity e:list){
                    simple.add(e);
                }
                map.put("entity",entity2);
                map.put("list",simple);
                return map;
            }
        }
        return null;
    }

    public static Elements getAllOnGames(WebClient webClient) {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.setJavaScriptErrorListener(new MyJSErrorListener());
        webClient.getOptions().setCssEnabled(false);//忽略Css
        webClient.setJavaScriptEngine(new MyJavaScriptEngine(webClient));//自定义JavaScript引擎，有js错误不打印
        webClient.getOptions().setTimeout(10000);
//        webClient.addRequestHeader("x-forwarded-for", ip + count);
        HtmlPage page = null;

        try {
            page = (HtmlPage)webClient.getPage("https://www.dorics.com/score");
//            page = (HtmlPage)webClient.getPage("https://www.635288.com/#/IP/B1");
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        webClient.waitForBackgroundJavaScript(1L);
        String pageXml = page.asXml();
        Document doc = Jsoup.parse(pageXml);
        if(doc.toString().contains("暂无比赛")){
            return null;
        }
        Elements allOnGames = null;
//        Elements teamWorks = doc.getElementsByTag("tbody");
            Elements teamWorks = doc.select("tbody[id=on]");
        if(teamWorks != null && teamWorks.size() > 0) {
            allOnGames = ((Element)teamWorks.get(0)).select("tr[id^=r]");
        }

        return allOnGames;
    }

    public static List<SimilarGameEntity> getSimilarGames(WebClient webClient, String url,BaseInfoEntity me) {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.setJavaScriptErrorListener(new MyJSErrorListener());
        webClient.getOptions().setCssEnabled(false);//忽略Css
        webClient.setJavaScriptEngine(new MyJavaScriptEngine(webClient));//自定义JavaScript引擎，有js错误不打印
        webClient.getOptions().setTimeout(10000);
//        webClient.addRequestHeader("x-forwarded-for", ip + count);
        HtmlPage page = null;
        List<SimilarGameEntity> list=new ArrayList<SimilarGameEntity>();
        try {
            page = (HtmlPage)webClient.getPage(url);
//            page = (HtmlPage)webClient.getPage("https://www.635288.com/#/IP/B1");
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        webClient.waitForBackgroundJavaScript(1L);
        String pageXml = page.asXml();
        Document doc = Jsoup.parse(pageXml);
       Elements pre=doc.select("p[class*=f16]");
       if(pre!=null&&pre.size()>0){
           Element master=null;
           Element guest=null;
           for(int i=0;i<pre.size();i++){
               Element el=pre.get(i);
               if(el.text().contains("主队近")){
                  master=el;
               }else if(el.text().contains("客队近")){
                   guest=el;
               }
           }
           if(master!=null){
           Elements trs=master.parent().select("tr");
           if(trs!=null&&trs.size()>0){
               for(Element tr:trs){
                  Elements tds=tr.select("td");
                  if(tds!=null&&tds.size()>0){
                      if(tds.get(2).select("a[class*=red]").size()==0){
                          continue;
                      }
                    String homeTeamName=tds.get(2).text().replace(" ","").replace(" ","");
                    String preHand=tds.get(6).text().replace(" ","").replace(" ","");
                    String data=preHand.substring(0,preHand.indexOf("/"));
                    if(data!=null&&!data.contains("-"));
                    Double value=Double.valueOf(data);
                    if(me.getHandicap()!=null&&value!=null&&value==me.getHandicap()){
//                      if(true){
                        SimilarGameEntity si=new SimilarGameEntity();
                        String guestTeamName=tds.get(4).text().replace(" ","").replace(" ","");
                        String time=tds.get(1).text().replace(" ","").replace(" ","");
                        String score=tds.get(3).text().replace(" ","").replace(" ","");
                        String gameName=tds.get(0).text().replace(" ","").replace(" ","");
                        si.setHandicap(value);
                        si.setHomeTeamName(homeTeamName);
                        si.setTime(time);
                        si.setScore(score);
                        si.setGameName(gameName);
                        si.setGuestTeamName(guestTeamName);
                        list.add(si);
                    }
                  }
               }
           }
           }
           if(guest!=null){
               Elements trs=guest.parent().select("tr");
               if(trs!=null&&trs.size()>0){
                   for(Element tr:trs){
                       Elements tds=tr.select("td");
                       if(tds!=null&&tds.size()>0){
                           if(tds.get(4).select("a[class*=blue]").size()==0){
                           continue;
                       }
                           String homeTeamName=tds.get(2).text().replace(" ","").replace(" ","");
                           String guestTeamName=tds.get(4).text().replace(" ","").replace(" ","");
                           String preHand=tds.get(6).text().replace(" ","").replace(" ","");
                           String data=preHand.substring(0,preHand.indexOf("/"));
                           if(data!=null&&!data.contains("-"));
                           Double value=Double.valueOf(data);
                           if(me.getHandicap()!=null&&value!=null&&value==me.getHandicap()){
//                           if(true){
                               SimilarGameEntity si=new SimilarGameEntity();
                               String time=tds.get(1).text().replace(" ","").replace(" ","");
                               String score=tds.get(3).text().replace(" ","").replace(" ","");
                               String gameName=tds.get(0).text().replace(" ","").replace(" ","");
                               si.setHandicap(value);
                               si.setHomeTeamName(homeTeamName);
                               si.setTime(time);
                               si.setScore(score);
                               si.setGameName(gameName);
                               si.setGuestTeamName(guestTeamName);
                               list.add(si);
                           }
                       }
                   }
               }

           }
       }

        return list;
    }

    public BaseInfoEntity getBasicInfomation1(Element teamWork) {
        BaseInfoEntity me = new BaseInfoEntity();
        try{
            me.setRaceId(teamWork.attr("rid"));
            if(raceIdList.contains(me.getRaceId())){
                return null;
            }
           String time= teamWork.select(
                    "td[class*=timeTd]").get(0).text().
                    replace(" ","").replace("'","");
           if(time.contains("半")){
               me.setTimeSeq(45);
           }else{
               me.setTimeSeq(Integer.valueOf(time));
           }
Elements team=teamWork.select("a[href*=team]");
me.setHomeTeamName(team.get(0).text());
me.setVisitingTeamName(team.get(1).text());
            team=teamWork.select("a[href*=league]");
            if(team.get(0)==null|| StringUtils.isBlank(team.get(0).text())){
                me.setLeagueName("");
            }else{
                me.setLeagueName(team.get(0).text().replace(" ","").replace(" ","" ));
            }
            //获取初始盘口  loginPopupBt body-font-color
Elements originHandicap=teamWork.select("a[class*=loginPopupBt]");
            if(originHandicap!=null&&originHandicap.size()>0){
                String handicap=originHandicap.get(0).text().replace(" ","").replace(" ","");
                me.setHandicap(Double.valueOf(handicap));
                System.out.println(me.getHandicap());
            }
//            www.dorics.com/race
            Elements urls=teamWork.select("a[href*=www.dorics.com/race]");
            if(urls!=null&&urls.size()>0){
                Element url=urls.get(0);
               String str="https:"+url.attr("href").replace(" ","").replace(" ","");
             try {
                 WebClient  webClient=new WebClient(BrowserVersion.CHROME);
                 System.out.println(str);
                 List<SimilarGameEntity> similar=getSimilarGames(webClient,str,me);
                 webClient.close();
                 if(similar!=null&&similar.size()>0){
                     me.setSimilarList(similar);
                 }
             }catch (Exception e){
                 e.printStackTrace();
             }

            }
        }catch(Exception e){
            me=null;
        }
        return me;
    }

}
