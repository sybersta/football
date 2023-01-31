package com.example.football.service.impl;

import com.example.football.Util.yzUtils;
import com.example.football.dao.MongoGoalLineTestRepository;
import com.example.football.dao.MongoRaceRepository;
import com.example.football.entity.MongoEntity.*;
import com.example.football.service.MongoService;
import com.example.football.service.MongoTestService;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.models.auth.In;
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
public class MongoServiceImpl implements MongoService {
@Autowired
    MongoRaceRepository mongoRaceRepository;
@Autowired
MongoTestService mongoTestService;
    @Autowired
    MongoGoalLineTestRepository mongoGoalLineTestRepository;
    @Override
    public void saveRace(MongoRaceEntity mongoRaceEntity) {
        mongoRaceRepository.save(mongoRaceEntity);
    }
    private static int count = 0;
    private static String ip = "192.168.10.24";
    private final static long now = new Date().getTime();
@Override
    public Thread getNewThread(Date date1) throws Exception{
        final Date date2=date1;
       return  new Thread(new Runnable() {
            public void run() {
                try {
                    Date date=new Date(date2.getTime());
                    while(date.getTime() < new SimpleDateFormat("yyyyMMdd").parse("20200102").getTime()) {
                        try {
                            ins(date,1);
                        } catch (Exception var2) {
                            var2.printStackTrace();
                        }
                        Calendar c1 = Calendar.getInstance();
                        c1.setTime(date);
                        c1.add(Calendar.DATE, 1);
                        date = c1.getTime();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public List<MongoRaceEntity> getList() {
        try {
            Date date= new SimpleDateFormat("yyyyMMdd").parse("20210701");
            while(date.getTime() <= new SimpleDateFormat("yyyyMMdd").parse("20210731").getTime()) {
                try {
                    String s=new SimpleDateFormat("yyyyMMdd").format(date);
                    List<MongoRaceEntity> list=mongoRaceRepository.findAllList(s,s,s);
                    if(list!=null&&list.size()>0){
                        for(MongoRaceEntity m:list){
                            MongoGoalLineTestEntity t=new MongoGoalLineTestEntity();
                            t.setHomeGoal(m.getHomeGoal());
                            t.setVisitingGoal(m.getVisitingGoal());
                            t.setTotalGoal(m.getTotalGoal());
                            t.setHomeTeamName(m.getHomeTeamName());
                            t.setVisitingTeamName(m.getVisitingTeamName());
                            List<MongoGoalLineEntity> goalLineList=m.getGoalLineList();
                            List<MongoHandicapEntity> handicapList=m.getHandicapList();
                            MongoGoalLineEntity entity1=new MongoGoalLineEntity();
                            MongoGoalLineEntity entity2=new MongoGoalLineEntity();
                            if(goalLineList!=null&&goalLineList.size()>0){
                                Integer timeCount=null;
                                Double lastUpperOdds=null;
                                Double lastLowerOdds=null;
                                Integer value=0;
                                Integer totalValue=0;
                                Double upperOdds=null;
                                Double lowerOdds=null;
                                for(int i=0;i<goalLineList.size();i++){
                                MongoGoalLineEntity goalLine=goalLineList.get(i);
                                if(Integer.valueOf(goalLine.getTimeSeq())>10||goalLine.getHomeGoal()+goalLine.getVisitingGoal()>0){
                                    t=null;
                                    break;
                                }
                                if(goalLine.getTimeSeq().contains("-")||goalLine.getGoalLine()==null){
                                    continue;
                                }
                               //主逻辑 获取初始盘口
                                    if(t.getGoalLine()==null){
                                        t.setGoalLine(goalLine.getGoalLine());
                                        t.setUpperOdds(goalLine.getUpperOdds());
                                        t.setLowerOdds(goalLine.getLowerOdds());
                                        timeCount=Integer.valueOf(goalLine.getTimeSeq());
                                        lastUpperOdds=goalLine.getUpperOdds();
                                        lastLowerOdds=goalLine.getLowerOdds();
                                        t.setTimeSeq(goalLine.getTimeSeq());
                                        if(Integer.valueOf(goalLine.getTimeSeq())>3){
                                            t=null;
                                            break;
                                        }
                                    }
                                    //开始计数
                                  if(timeCount!=null){
                                   if(goalLine.getTimeSeq().equals(timeCount+"")){
                                       upperOdds=goalLine.getUpperOdds();
                                       lowerOdds=goalLine.getLowerOdds();
                                       lastUpperOdds=goalLine.getUpperOdds();
                                       lastLowerOdds=goalLine.getLowerOdds();
                                       timeCount++;
                                   }else if(Integer.valueOf(goalLine.getTimeSeq())<timeCount){
                                       lastUpperOdds=goalLine.getUpperOdds();
                                       lastLowerOdds=goalLine.getLowerOdds();
                                       continue;
                                   }else if(Integer.valueOf(goalLine.getTimeSeq())==timeCount+1){
                                       upperOdds=lastUpperOdds;
                                       lowerOdds=lastLowerOdds;
                                       timeCount++;
                                   }else{
                                       t=null;
                                       break;
                                   }
                                  if(upperOdds!=null&&lowerOdds!=null){
                                        if(upperOdds>lowerOdds){
                                            value++;
                                        }else if(upperOdds<lowerOdds){
                                            value--;
                                        }
                                  }
                                  }

                                }
                            }
                            if(t!=null){
                                if(handicapList!=null&&handicapList.size()>0){
                                    for(int i=0;i<handicapList.size();i++){
                                        MongoHandicapEntity handicap=handicapList.get(i);
                                        if(handicap.getTimeSeq().contains("-")||handicap.getHandicap()==null){
                                            continue;
                                        }
                                        //主逻辑 获取初始盘口
                                        if(t.getHandicap()==null){
                                           t.setHandicap(handicap.getHandicap());
                                        }else{
                                            break;
                                        }

                                    }
                                }
                                mongoGoalLineTestRepository.save(t);
                            }
                        }
                    }
                } catch (Exception var2) {
                    var2.printStackTrace();
                }
                Calendar c1 = Calendar.getInstance();
                c1.setTime(date);
                c1.add(Calendar.DATE, 1);
                date = c1.getTime();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//for(int k=date;k<=lastDay;k++){
//
//}


        return null;
    }

    @Override
    public  void ins(Date date,int num) throws Exception {
        try {
            String sd=(new SimpleDateFormat("yyyyMMdd")).format(date);
            System.out.println(sd);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            for(int p=num;true;p++){
                Elements allOnGames = getAllOnGames(httpClient, (new SimpleDateFormat("yyyyMMdd")).format(date),p);
                if(allOnGames != null && allOnGames.size() > 0) {
                    Iterator c = allOnGames.iterator();

                    while(c.hasNext()) {
                        Element teamWork = (Element)c.next();
                        MongoRaceEntity m=null;
                        try{
                            m= getBasicInfomation1(teamWork,sd);
                            if(m==null){
                                continue;
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        try{
                            m=insertGoalData(teamWork,m);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        try{
                            insertData(m);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    httpClient.close();
                    break;
                }
            }
        } catch (Exception var11) {
            System.out.println("异常2");
        }
    }

//    public void ins(Date date) throws Exception {
//        try {
//            WebClient var10 = new WebClient(BrowserVersion.CHROME);
//            String sd=(new SimpleDateFormat("yyyyMMdd")).format(date);
//            System.out.println(sd);
//            for(int p=1;true;p++){
//                Elements allOnGames = getAllOnGames(var10, (new SimpleDateFormat("yyyyMMdd")).format(date),p);
//                if(allOnGames != null && allOnGames.size() > 0) {
//                    Iterator c = allOnGames.iterator();
//
//                    while(c.hasNext()) {
//                        Element teamWork = (Element)c.next();
//                        MongoRaceEntity m=null;
//                        try{
//                            m= getBasicInfomation1(teamWork,sd);
//                            if(m==null){
//                                continue;
//                            }
//                        }catch(Exception e){
//                            e.printStackTrace();
//                        }
//                        try{
//                            m=insertGoalData(teamWork,m);
//                        }catch(Exception e){
//                            e.printStackTrace();
//                        }
//                        try{
//                            insertData(m);
//                        }catch(Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                else{
//                    var10.getCookieManager().clearCookies();
//                    var10.close();
//                    break;
//                }
//            }
//        } catch (Exception var11) {
//            System.out.println("异常2");
//        }
//
//
//    }

//    public static Elements getAllOnGames(WebClient webClient, String time,int p) {
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setActiveXNative(false);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
//        webClient.getOptions().setTimeout(10000);
////        webClient.addRequestHeader("x-forwarded-for", ip + count);
//        ++count;
//        if(count > 254) {
//            count = 0;
//        }
//        System.out.println("time:"+time);
//        HtmlPage page = null;
//
//        try {
//            page = (HtmlPage)webClient.getPage("https://www.dszuqiu.com/diary/" + time+"/p."+p);
////            page = (HtmlPage)webClient.getPage("https://www.635288.com/#/IP/B1");
//        } catch (Exception var7) {
//            var7.printStackTrace();
//        }
//
//        webClient.waitForBackgroundJavaScript(1L);
//        String pageXml = page.asXml();
//        Document doc = Jsoup.parse(pageXml);
//        if(doc.toString().contains("暂无比赛")){
//            return null;
//        }
//        Elements allOnGames = null;
//        Elements teamWorks = doc.getElementsByTag("tbody");
//        if(teamWorks != null && teamWorks.size() > 0) {
//            allOnGames = ((Element)teamWorks.get(0)).getElementsByTag("tr");
//        }
//
//        return allOnGames;
//    }

    public static Elements getAllOnGames(CloseableHttpClient httpClient, String time,int p) {
        HttpGet httpget = new HttpGet("https://www.dorics.com/diary/" + time+"/p."+p);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(5000).build();
        httpget.setConfig(requestConfig);
        httpget.addHeader("Accept-Encoding", "gzip, deflate, br");
        httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpget.addHeader("Cache-Control", "max-age=0");
        httpget.addHeader("Connection", "keep-alive");
        httpget.addHeader("Content-Type", "text/html; charset=utf-8");
        httpget.addHeader("referer","https://www.dorics.com/diary/last");
        httpget.addHeader("Cookie","ds_session=25459vq37rugcj841uj8t3dig0; Hm_lvt_ea7eaca9beb0e50422887c64e87c3b92=1628302595; uid=R-608424-45b9edc00610dee55c5558; Hm_lpvt_ea7eaca9beb0e50422887c64e87c3b92=1628302924");
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
        httpget.addHeader("x-forwarded-for", ip);
//        ++count;
//        if(count > 254) {
//            count = 0;
//        }
        CloseableHttpResponse response = null;

        MongoRaceEntity temp;
        String isGzip="1";
        Elements allOnGames = null;
        try {
            response = httpClient.execute(httpget);
            if (response.getStatusLine().getStatusCode() != 200) {
                return null;
            }
            Header[] headers = response.getHeaders("Content-Encoding");
            for (Header h : headers) {
                if (h.getValue().equals("gzip")) {
                    isGzip = "2";
                    break;
                }
                if (h.getValue().equals("br")) {
                    isGzip = "3";
                    break;
                }
            }
            String content = null;
            if (isGzip.equals("2")) {
                content = EntityUtils.toString(new GzipDecompressingEntity(response.getEntity()));
            } else if (isGzip.equals("1")) {
                HttpEntity e = response.getEntity();
                ContentType contentType = ContentType.getOrDefault(e);
                Charset charset = contentType.getCharset();
                content = EntityUtils.toString(e, charset);
            } else {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BrotliInputStream(response.getEntity().getContent())));
                StringBuilder result = new StringBuilder();
                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                    result.append(str);
                }
                content = result.toString();
            }
            Document doc = Jsoup.parse(content);

            if (doc.toString().contains("暂无比赛")) {
                return null;
            }

            Elements teamWorks = doc.getElementsByTag("tbody");
            if (teamWorks != null && teamWorks.size() > 0) {
                allOnGames = ((Element) teamWorks.get(0)).getElementsByTag("tr");
            }
        }catch (final java.net.SocketTimeoutException e) {
            allOnGames=getAllOnGames(httpClient, time,p);
        } catch(Exception e){
            e.printStackTrace();
        }
        return allOnGames;
    }

    public MongoRaceEntity getBasicInfomation1(Element teamWork,String sd) {
//    	System.out.println(teamWork.toString());
        MongoRaceEntity me = new MongoRaceEntity();
        me.setDate(sd);
        Random random = new Random();
        int ends = random.nextInt()*100;
        String prefix=String.format("%02d",ends);
        try{
            me.setRaceId(((Element)teamWork.getElementsByTag("a").get(3)).attr("href").split("/")[2]);
            me.setId(prefix+me.getRaceId());
            me.setLeagueName(((Element)teamWork.getElementsByAttributeValueMatching("class", "bg+").get(0)).text());
            me.setHomeTeamName(((Element)((Element)teamWork.getElementsByClass("text-right").get(0)).getElementsByTag("a").get(0)).text());
            me.setVisitingTeamName(((Element)((Element)teamWork.getElementsByClass("text-left").get(0)).getElementsByTag("a").get(0)).text());
            String score = ((Element)teamWork.getElementsByClass("BR0 text-center red-color PL0 PR0").get(0)).ownText();
            String[] bifen = score.split(":");
            int homeScore = Integer.parseInt(bifen[0].trim());
            int visitScore = Integer.parseInt(bifen[1].trim());


            me.setHomeGoal(homeScore);
            me.setVisitingGoal(visitScore);
            me.setTotalGoal(homeScore+visitScore);
            score = ((Element)teamWork.getElementsByClass("text-center red-color").get(0)).ownText();
            bifen = score.split(":");
            homeScore = Integer.parseInt(bifen[0].trim());
            visitScore = Integer.parseInt(bifen[1].trim());
            me.setMidHomeGoal(homeScore);
            me.setMidVisitingGoal(visitScore);
            me.setMidGoal(homeScore+visitScore);
                me = yzUtils.getOriginalPosition(me, ip, count);
//            ++count;
//            if(count > 250) {
//                count = 0;
//            }
        }catch(Exception e){
            me=null;
        }
        return me;
    }

    private  void insertData(MongoRaceEntity m) {
        mongoRaceRepository.save(m);

    }

    public static MongoRaceEntity insertGoalData(Element teamWork,MongoRaceEntity m){
        Elements e= teamWork.getElementsByClass("timeLineGoal");
        List<MongoGoalEntity> list= new ArrayList<MongoGoalEntity>();
        try{
            if(e!=null&&e.size()>0){
                for(int i=0;i<e.size();i++){
                    MongoGoalEntity goal=new MongoGoalEntity();
                    goal.setId(i+1);
//    		   System.out.println("enter");
                    goal.setSeq(e.get(i).attr("title").split("\\'")[0].trim().replace(" ", "").split("\\+")[0]);
                    if(e.get(i).getElementsByTag("img")!=null&&e.get(i).getElementsByTag("img").size()>0){
                        Element a= e.get(i).getElementsByTag("img").get(0);
                        if(a.attr("src").contains("hp.png")||a.attr("src").contains("hg.png")||a.attr("src").contains("hw.png")){
                            goal.setTeam(1);
                        }else if(a.attr("src").contains("gp.png")||a.attr("src").contains("gg.png")||a.attr("src").contains("gw.png")){
                            goal.setTeam(0);
                        }else{
                            continue;
                        }
                    }
                    list.add(goal);
                }
            }
        }catch(Exception e1){
            System.out.println("异常444");
        }
        m.setMongoGoalList(list);
        return m;
    }

//    public static void main (String[] args){
//        WebClient webClient= new WebClient(BrowserVersion.CHROME);//设置浏览器
//        webClient.getOptions().setUseInsecureSSL(true);
//        webClient.getOptions().setCssEnabled(true);//设置css是否生效
//        webClient.getOptions().setJavaScriptEnabled(true);//设置js是否生效
//        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//设置ajax请求
//        webClient.getOptions().setTimeout(10000);
//        webClient.waitForBackgroundJavaScript(3000);
//        HtmlPage htmlPage = null;
//        try {
//            htmlPage = webClient.getPage("https://auction.rmfysszc.gov.cn/Result.aspx");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }//访问路径设置
//        System.out.println(htmlPage.asXml());
//        webClient.close();
//        System.out.println("Success");
//        System.exit(0);
//    }
}
