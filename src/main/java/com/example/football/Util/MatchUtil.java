//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.football.Util;

import com.example.football.entity.MongoEntity.*;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchUtil {
//	public static DecimalFormat df = new DecimalFormat("00.000");
    public MatchUtil() {
    }

//    public static void main(String[] args) throws IOException {
////    	getOriginalPosition(new MongoRaceEntity(), " 192.168.31.4",12);
//       String s= "05/04 01:39";
//
//    }

    public static BaseInfoEntity getOriginalPosition(BaseInfoEntity m, String ip) {
        System.out.println(m.getRaceId() + m.getHomeTeamName()+":start");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.dorics.com/race_sp/" + m.getRaceId());
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(5000).build();
        httpget.setConfig(requestConfig);
//        httpget.addHeader("Cookie", "race_id="+m.getRaceId()+"; uid=R-590961-283ea6710610792b0685af; ds_session=b7erh0uug949a7teli3nepku36; Hm_lvt_a68414d98536efc52eeb879f984d8923=1627886171,1627959604; cf_chl_rc_m=1; cf_chl_2=7d527b0e582eb6b; cf_chl_prog=a11; cf_clearance=bc0f1f635abcfbd9bcf20629e46f438b00586463-1627962212-0-150; __cf_bm=0e47bf8c713fdcbcff0c38317e1b6bdb403a773d-1627962275-1800-AfQxKnZfZzDokxdjnQGZSx291uPMYGMf34xlriF1z7fxh/9JNHI43tq87MA8QmViOln4xUpLpOVNSgOf/p6K37L9PjTU6+OESb7Lqlgye+/cGvq2CoA2MZEB0+Djkhde1g==; Hm_lpvt_a68414d98536efc52eeb879f984d8923=1627962259");
        httpget.addHeader("Cookie","ds_session=25459vq37rugcj841uj8t3dig0; Hm_lvt_ea7eaca9beb0e50422887c64e87c3b92=1628302595; uid=R-608424-45b9edc00610dee55c5558; Hm_lpvt_ea7eaca9beb0e50422887c64e87c3b92=1628303177");
        httpget.addHeader("Accept-Encoding", "gzip, deflate, br");
        httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpget.addHeader("Cache-Control", "max-age=0");
        httpget.addHeader("Connection", "keep-alive");
        httpget.addHeader("Content-Type", "text/html; charset=utf-8");
        httpget.addHeader("Referer", "https://www.dorics.com/race_fx/"+m.getRaceId());
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
        httpget.addHeader("x-forwarded-for", ip);
        CloseableHttpResponse response = null;

        BaseInfoEntity temp;
        String isGzip="1";
        try {
            try {
                response = httpClient.execute(httpget);
            }catch(Exception e){
                System.out.println("检查cookie，连接失败");
            }
            if(response.getStatusLine().getStatusCode() != 200) {
                System.out.println("response 返回不正确");
                return m;
            }
            Header[] headers= response.getHeaders("Content-Encoding");
            for(Header h:headers){
                if(h.getValue().equals("gzip")){
                    isGzip= "2";
                    break;
                }
                if(h.getValue().equals("br")){
                    isGzip= "3";
                    break;
                }
            }
            String content =null;
            if(isGzip.equals("2")){
                content= EntityUtils.toString(new GzipDecompressingEntity(response.getEntity()));
            }else if(isGzip.equals("1")) {
                HttpEntity e = response.getEntity();
                ContentType contentType = ContentType.getOrDefault(e);
                Charset charset = contentType.getCharset();
                content = EntityUtils.toString(e, charset);
            }else {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BrotliInputStream(response.getEntity().getContent())));
                StringBuilder result = new StringBuilder();
                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                    result.append(str);
                }
                content=result.toString();
            }
            Document doc = Jsoup.parse(content);
//            try{
//                m = setPankouValue(doc, m);
//            }catch(Exception em){
//                System.out.println("盘口");
//            }
            try{
                m = setDaxiaoValue(doc, m);
            }catch(Exception em){
                System.out.println("大小");
            }
//            try{
//                m = setSpfValue(doc, m);
//            }catch(Exception em){
//                System.out.println("胜平负");
//            }
            temp = m;
        } catch (IOException var23) {
            var23.printStackTrace();
            return m;
        } finally {
            try {
                response.close();
            } catch (IOException var22) {
                var22.printStackTrace();
            }

            try {
                httpClient.close();
            } catch (IOException var21) {
                var21.printStackTrace();
            }

        }

        return temp;
    }


    public static BaseInfoEntity setPankouValue(Document doc, BaseInfoEntity m) {
//        Element rf = doc.getElementById("sp_rangfen");
        Element rf = doc.getElementById("rangqiu1");
        Elements tr = rf.getElementsByTag("tr");
        Elements tr2;
        String[] tr3;
        if(tr != null && tr.size() > 0) {
            List<MongoHandicapEntity> list=new ArrayList<MongoHandicapEntity>();
            int tr1 = tr.size() - 1;

            int num=1;
            for(int i=tr.size()-1;i>=0;i--) {
                try {
                    MongoHandicapEntity mongo = new MongoHandicapEntity();
                Elements tds = ((Element) tr.get(i)).getElementsByTag("td");
                if (tds != null && tds.size() > 0) {
                    if(tds.get(2).text()==null||tds.get(2).text().contains("-")){
                        continue;
                    }
                    mongo.setTimeSeq(getStringVal(tds.get(0).text()));
                    String score = getStringVal(tds.get(1).text());
                    if(score!=null&&!score.contains("-")) {
                        String[] sq = score.split(":");
                        mongo.setHomeGoal(getIntVal(sq[0]));
                        mongo.setVisitingGoal(getIntVal(sq[1]));
                    }
                    tr3 = (tds.get(3)).text().split(",");
                    Double td = new BigDecimal(tr3[0]).doubleValue();
                    if(tr3.length > 1) {
                        td = (getVal(tr3[0]) + getVal(tr3[1])) / 2.00D;
                    }
                    mongo.setHandicap(td);
                    mongo.setHomeOdds(getVal(((Element)tds.get(2)).text()));
                    mongo.setVisitingOdds(getVal(((Element)tds.get(4)).text()));
                    mongo.setTime(tds.get(5).text());
                    mongo.setId(String.valueOf(num));
                    num++;
                    if(mongo!=null&&(mongo.getTimeSeq().contains("6")||
                            mongo.getTimeSeq().contains("24")||mongo.getTimeSeq().contains("42"))){
                  list.add(mongo);}
                }
            }catch(Exception e){
                    int abc=0;
                }
            }
            m.setHandicapList(list);
        }

        return m;
    }

    public static BaseInfoEntity setDaxiaoValue(Document doc, BaseInfoEntity m) {
//        Element rf = doc.getElementById("sp_daxiao");
        Element rf = doc.getElementById("daxiao1");
        Elements tr = rf.getElementsByTag("tr");
        Elements tr2;
        String[] tr3;
        Double originPk=null;
        Double pk=null;
        if(tr != null && tr.size() > 0) {
            List<MongoGoalLineEntity> list=new ArrayList<MongoGoalLineEntity>();
            int tr1 = tr.size() - 1;

            int num=1;
            for(int i=tr.size()-1;i>=0;i--) {
                try {
                    MongoGoalLineEntity mongo = new MongoGoalLineEntity();
                    Elements tds = ((Element) tr.get(i)).getElementsByTag("td");
                    if (tds != null && tds.size() > 0) {
                        if(tds.get(2).text()==null||tds.get(2).text().contains("-")){
                            continue;
                        }
                        mongo.setTimeSeq(getStringVal(tds.get(0).text()));
                        String score = getStringVal(tds.get(1).text());
                        if(score!=null&&!score.contains("-")) {
                            String[] sq = score.split(":");
                            mongo.setHomeGoal(getIntVal(sq[0]));
                            mongo.setVisitingGoal(getIntVal(sq[1]));
                        }
                        tr3 = (tds.get(3)).text().split(",");
                        Double td = new BigDecimal(tr3[0]).doubleValue();
                        if(tr3.length > 1) {
                            td = (getVal(tr3[0]) + getVal(tr3[1])) / 2.00D;
                        }
                        mongo.setGoalLine(td);
                        mongo.setUpperOdds(getVal(((Element)tds.get(2)).text()));
                        mongo.setLowerOdds(getVal(((Element)tds.get(4)).text()));
                        mongo.setTime(tds.get(5).text());
                        mongo.setId(String.valueOf(num));
                        num++;
                        if(originPk==null&&!mongo.getTimeSeq().contains("-")){
                           originPk=mongo.getGoalLine();
                        }
                        if(pk==null) {
                            if (mongo.getTimeSeq().contains("10") || mongo.getTimeSeq().contains("11")) {
                                pk=mongo.getGoalLine();
                            }
                        }
                        if(mongo!=null&&(Integer.valueOf(mongo.getTimeSeq()))>11){
                            break;

                        }
                    }
                }catch(Exception e){
                    int abc=0;
                }
            }
            if(originPk!=null&&pk!=null&&originPk-pk>=0.5){
                m.setBigMessage(">>大球");
            }
            if(originPk!=null&&pk!=null&&originPk-pk==0){
                m.setSamllMessage(">>小球");
            }
            m.setGoalLineList(list);
        }



        return m;
    }

    public static BaseInfoEntity setSpfValue(Document doc, BaseInfoEntity m) {
//        Element rf = doc.getElementById("sp_bet");
        Element rf = doc.getElementById("shengping1");
        Elements tr = rf.getElementsByTag("tr");
        Elements tr2;
        if(tr != null && tr.size() > 0) {
            List<MongoWinDrawEntity> list= new ArrayList<MongoWinDrawEntity>();
            int tr1 = tr.size() - 1;

            int num=1;
            for(int i=tr.size()-1;i>=0;i--) {
                try {
                    MongoWinDrawEntity mongo = new MongoWinDrawEntity();
                    Elements tds = ((Element) tr.get(i)).getElementsByTag("td");
                    if (tds != null && tds.size() > 0) {
                        if(tds.get(2).text()==null||tds.get(2).text().contains("-")){
                            continue;
                        }
                        mongo.setTimeSeq(getStringVal(tds.get(0).text()));
                        String score = getStringVal(tds.get(1).text());
                        if(score!=null&&!score.contains("-")) {
                            String[] sq = score.split(":");
                            mongo.setHomeGoal(getIntVal(sq[0]));
                            mongo.setVisitingGoal(getIntVal(sq[1]));
                        }
                        mongo.setWinOdds(getVal(((Element)tds.get(2)).text()));
                        mongo.setDrawOdds(getVal(((Element)tds.get(3)).text()));
                        mongo.setLostOdds(getVal(((Element)tds.get(4)).text()));
                        mongo.setTime(tds.get(5).text());
                        mongo.setId(String.valueOf(num));
                        num++;
                        if(mongo!=null&&(mongo.getTimeSeq().contains("6")||
                                mongo.getTimeSeq().contains("24")||mongo.getTimeSeq().contains("42"))){
                            list.add(mongo);}
                    }
                }catch(Exception e){
                    int abc=0;
                }
            }
            m.setMongoWinDrawList(list);

        }
        return m;
    }
    
    public static int getds(String s){
    	HashMap<String,Integer> m=new HashMap<String,Integer>();
    	m.put("1.500", 1);
    	m.put("1.533", 2);
    	m.put("1.571", 3);
    	m.put("1.615", 4);
    	m.put("1.666", 5);
    	m.put("1.727", 6);
    	m.put("1.800", 7);
    	m.put("1.833", 8);
    	m.put("1.909", 9);
    	m.put("1.952", 10);
    	m.put("2.000", 11);
    	m.put("2.050", 12);
    	m.put("2.100", 13);
    	m.put("2.200", 14);
    	if(m.containsKey(s)){
    		return m.get(s);
    	}
    	return 0;
    }
    
    public static Double getVal(String s){
    	try{
    	return new BigDecimal(s.replace(" ", "").replace("↑", "").replace("↓", "")).doubleValue();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }

    public static String getStringVal(String s){
        try{
            return s.replace(" ", "").replace("↑", "").replace("↓", "").replace("'","");
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Integer getIntVal(String s){
        try{
            return Integer.valueOf(s.replace(" ", "").replace("↑", "").replace("↓", "").replace("'",""));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
