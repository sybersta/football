package com.example.football.temp;

import com.example.football.Util.MatchUtil;
import com.example.football.entity.MongoEntity.BaseInfoEntity;
import com.example.football.entity.MongoEntity.MongoGoalLineEntity;
import com.example.football.entity.MongoEntity.MongoHandicapEntity;
import com.example.football.entity.MongoEntity.MongoWinDrawEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class testSameOdds {
    {
//        Element teamWork = (Element)c.next();
//        BaseInfoEntity m=null;
//        try{
//            m= getBasicInfomation1(teamWork);
//            if(m==null||m.getTimeSeq()==null||
//                    m.getRaceId()==null||raceIdList.contains(m.getRaceId())){
//                continue;
//            }
//            MatchUtil.getOriginalPosition(m,ip);
//                              raceIdList.add(m.getRaceId());
//                              查询数据库并比较
//                          HashMap<String,Object> winDrawMap= AnalysisWinDrawLost(m);
//                          HashMap<String,Object> goalLineMap=AnalysisGoalLine(m);
//                          HashMap<String,Object> handicapMap=AnalysisHandicap(m);
//            String str=m.getLeagueName()+"》"+m.getHomeTeamName()+"vs"+m.getVisitingTeamName()+"\n";
//            System.out.println("startpd");
//                          if(winDrawMap!=null&&winDrawMap.get("list")!=null) {
//                              List<SimpleRaceEntity> winDrawList= (List<SimpleRaceEntity>) winDrawMap.get("list");
//                              MongoWinDrawEntity entity= (MongoWinDrawEntity) winDrawMap.get("entity");
////                              排序
//                              Comparator<SimpleRaceEntity> comparator = Comparator.comparing(item -> item.getDate());
//                              winDrawList.sort(comparator.reversed());
//                              if (winDrawList != null && winDrawList.size() > 0) {
//                                  String message1 = "胜平负》" + new String(str);
//                                  message1+=entity.getTimeSeq()+"分:比分》"+entity.getHomeGoal()+":"+entity.getVisitingGoal()+" 赔率： "+
//                                          entity.getWinOdds()+"  "
//                                          +entity.getDrawOdds()+"  "+entity.getLostOdds()+"\n";
//                                  if(entity.getHomeGoal()==entity.getVisitingGoal()) {
//                                      for (SimpleRaceEntity sim : winDrawList) {
//                                          message1 += sim.getLeagueName() + ">>" + sim.getHomeGoal() + ":" + sim.getVisitingGoal() + "---" + sim.getDate() + "\n";
//                                      }
//                                      new WeixinRoket().sendMessage(message1);
//                                  }
////                              微信机器人
//                              MongoWinDrawRecommandEntity win=new MongoWinDrawRecommandEntity();
//                              win.setRaceId(m.getRaceId());
//                              win.setRaceList(winDrawList);
//                              mongoWinDrawRecommandRepository.save(win);
//                              }
//                          }
//                              if(goalLineMap!=null&&goalLineMap.get("list")!=null) {
//                                  List<SimpleRaceEntity> goalLineList= (List<SimpleRaceEntity>) goalLineMap.get("list");
//                                  MongoGoalLineEntity entity= (MongoGoalLineEntity) goalLineMap.get("entity");
////                                  排序
//                                  Comparator<SimpleRaceEntity> comparator = Comparator.comparing(item -> item.getDate());
//                                  goalLineList.sort(comparator.reversed());
//                                  if (goalLineList != null && goalLineList.size() > 0) {
//                                      String message2 = "大小球》" + new String(str);
//                                      message2+=entity.getTimeSeq()+"分:比分》"+entity.getHomeGoal()+"："+entity.getVisitingGoal()+" 盘口："+entity.getGoalLine()+"\n";
////                                      if(goalLineList.size()==1||goalLineList.size()==2){
//                                          for(SimpleRaceEntity sim:goalLineList){
//                                              message2+=sim.getLeagueName()+">>"+sim.getHomeGoal()+":"+sim.getVisitingGoal()+"---"+sim.getDate()+"\n";
//                                          }
//                                          new WeixinRoket().sendMessage(message2);
////                                      }
//
////                              微信机器人
//                              MongoGoalLineRecommandEntity goalLine=new MongoGoalLineRecommandEntity();
//                              goalLine.setRaceId(m.getRaceId());
//                              goalLine.setRaceList(goalLineList);
//                              mongoGoalLineRecommandRepository.save(goalLine);
//
//                          }
//                              }
//                              if(handicapMap!=null&&handicapMap.get("list")!=null) {
//                                  List<SimpleRaceEntity> handicapList= (List<SimpleRaceEntity>) handicapMap.get("list");
//                                  MongoHandicapEntity entity= (MongoHandicapEntity) handicapMap.get("entity");
// //                                  排序
//                                  Comparator<SimpleRaceEntity> comparator = Comparator.comparing(item -> item.getDate());
//                                  handicapList.sort(comparator.reversed());
//                                  if (handicapList != null && handicapList.size() > 0&&handicapList.size()<9) {
//                                      String message3 = "盘口》" + new String(str);
//                                      message3+=entity.getTimeSeq()+"分:比分》"+entity.getHomeGoal()+"："+entity.getVisitingGoal()+" 盘口："+entity.getHandicap()+"\n";
//                              if(entity.getHomeGoal()!=entity.getVisitingGoal()) {
//                                  for (SimpleRaceEntity sim : handicapList) {
//                                      message3 += sim.getLeagueName() + ">>" + sim.getHomeGoal() + ":" + sim.getVisitingGoal() + "---" + sim.getDate() + "\n";
//                                  }
//                                  new WeixinRoket().sendMessage(message3);
//                              }
////                              微信机器人
//                              MongoHandicapRecommandEntity mh=new MongoHandicapRecommandEntity();
//                              mh.setRaceId(m.getRaceId());
//                              mongoHandicapRecommandRepository.save(mh);
//
//                          }
//                                  }
//        }catch(Exception e){
//            e.printStackTrace();
//        }

//        part2


//        public static BaseInfoEntity setPankouValue(Document doc, BaseInfoEntity m) {
////        Element rf = doc.getElementById("sp_rangfen");
//        Element rf = doc.getElementById("rangqiu1");
//        Elements tr = rf.getElementsByTag("tr");
//        Elements tr2;
//        String[] tr3;
//        if(tr != null && tr.size() > 0) {
//            List<MongoHandicapEntity> list=new ArrayList<MongoHandicapEntity>();
//            int tr1 = tr.size() - 1;
//
//            int num=1;
//            for(int i=tr.size()-1;i>=0;i--) {
//                try {
//                    MongoHandicapEntity mongo = new MongoHandicapEntity();
//                    Elements tds = ((Element) tr.get(i)).getElementsByTag("td");
//                    if (tds != null && tds.size() > 0) {
//                        if(tds.get(2).text()==null||tds.get(2).text().contains("-")){
//                            continue;
//                        }
//                        mongo.setTimeSeq(getStringVal(tds.get(0).text()));
//                        String score = getStringVal(tds.get(1).text());
//                        if(score!=null&&!score.contains("-")) {
//                            String[] sq = score.split(":");
//                            mongo.setHomeGoal(getIntVal(sq[0]));
//                            mongo.setVisitingGoal(getIntVal(sq[1]));
//                        }
//                        tr3 = (tds.get(3)).text().split(",");
//                        Double td = new BigDecimal(tr3[0]).doubleValue();
//                        if(tr3.length > 1) {
//                            td = (getVal(tr3[0]) + getVal(tr3[1])) / 2.00D;
//                        }
//                        mongo.setHandicap(td);
//                        mongo.setHomeOdds(getVal(((Element)tds.get(2)).text()));
//                        mongo.setVisitingOdds(getVal(((Element)tds.get(4)).text()));
//                        mongo.setTime(tds.get(5).text());
//                        mongo.setId(String.valueOf(num));
//                        num++;
//                        if(mongo!=null&&(mongo.getTimeSeq().contains("6")||
//                                mongo.getTimeSeq().contains("24")||mongo.getTimeSeq().contains("42"))){
//                            list.add(mongo);}
//                    }
//                }catch(Exception e){
//                    int abc=0;
//                }
//            }
//            m.setHandicapList(list);
//        }
//
//        return m;
//    }
//
//        public static BaseInfoEntity setDaxiaoValue(Document doc, BaseInfoEntity m) {
////        Element rf = doc.getElementById("sp_daxiao");
//        Element rf = doc.getElementById("daxiao1");
//        Elements tr = rf.getElementsByTag("tr");
//        Elements tr2;
//        String[] tr3;
//        if(tr != null && tr.size() > 0) {
//            List<MongoGoalLineEntity> list=new ArrayList<MongoGoalLineEntity>();
//            int tr1 = tr.size() - 1;
//
//            int num=1;
//            for(int i=tr.size()-1;i>=0;i--) {
//                try {
//                    MongoGoalLineEntity mongo = new MongoGoalLineEntity();
//                    Elements tds = ((Element) tr.get(i)).getElementsByTag("td");
//                    if (tds != null && tds.size() > 0) {
//                        if(tds.get(2).text()==null||tds.get(2).text().contains("-")){
//                            continue;
//                        }
//                        mongo.setTimeSeq(getStringVal(tds.get(0).text()));
//                        String score = getStringVal(tds.get(1).text());
//                        if(score!=null&&!score.contains("-")) {
//                            String[] sq = score.split(":");
//                            mongo.setHomeGoal(getIntVal(sq[0]));
//                            mongo.setVisitingGoal(getIntVal(sq[1]));
//                        }
//                        tr3 = (tds.get(3)).text().split(",");
//                        Double td = new BigDecimal(tr3[0]).doubleValue();
//                        if(tr3.length > 1) {
//                            td = (getVal(tr3[0]) + getVal(tr3[1])) / 2.00D;
//                        }
//                        mongo.setGoalLine(td);
//                        mongo.setUpperOdds(getVal(((Element)tds.get(2)).text()));
//                        mongo.setLowerOdds(getVal(((Element)tds.get(4)).text()));
//                        mongo.setTime(tds.get(5).text());
//                        mongo.setId(String.valueOf(num));
//                        num++;
//                        if(mongo!=null&&(mongo.getTimeSeq().contains("6")||
//                                mongo.getTimeSeq().contains("24")||mongo.getTimeSeq().contains("42"))){
//                            list.add(mongo);}
//                    }
//                }catch(Exception e){
//                    int abc=0;
//                }
//            }
//            m.setGoalLineList(list);
//        }
//
//
//
//        return m;
//    }
//
//        public static BaseInfoEntity setSpfValue(Document doc, BaseInfoEntity m) {
////        Element rf = doc.getElementById("sp_bet");
//        Element rf = doc.getElementById("shengping1");
//        Elements tr = rf.getElementsByTag("tr");
//        Elements tr2;
//        if(tr != null && tr.size() > 0) {
//            List<MongoWinDrawEntity> list= new ArrayList<MongoWinDrawEntity>();
//            int tr1 = tr.size() - 1;
//
//            int num=1;
//            for(int i=tr.size()-1;i>=0;i--) {
//                try {
//                    MongoWinDrawEntity mongo = new MongoWinDrawEntity();
//                    Elements tds = ((Element) tr.get(i)).getElementsByTag("td");
//                    if (tds != null && tds.size() > 0) {
//                        if(tds.get(2).text()==null||tds.get(2).text().contains("-")){
//                            continue;
//                        }
//                        mongo.setTimeSeq(getStringVal(tds.get(0).text()));
//                        String score = getStringVal(tds.get(1).text());
//                        if(score!=null&&!score.contains("-")) {
//                            String[] sq = score.split(":");
//                            mongo.setHomeGoal(getIntVal(sq[0]));
//                            mongo.setVisitingGoal(getIntVal(sq[1]));
//                        }
//                        mongo.setWinOdds(getVal(((Element)tds.get(2)).text()));
//                        mongo.setDrawOdds(getVal(((Element)tds.get(3)).text()));
//                        mongo.setLostOdds(getVal(((Element)tds.get(4)).text()));
//                        mongo.setTime(tds.get(5).text());
//                        mongo.setId(String.valueOf(num));
//                        num++;
//                        if(mongo!=null&&(mongo.getTimeSeq().contains("6")||
//                                mongo.getTimeSeq().contains("24")||mongo.getTimeSeq().contains("42"))){
//                            list.add(mongo);}
//                    }
//                }catch(Exception e){
//                    int abc=0;
//                }
//            }
//            m.setMongoWinDrawList(list);
//
//        }
//        return m;
//    }
    }

}
