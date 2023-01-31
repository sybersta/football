package com.example.football.entity.MongoEntity;

import com.example.football.entity.SimilarGameEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class BaseInfoEntity {
   private String id;
   private String date;
   private String raceId;
   private Integer timeSeq;
   private String url;
   private Integer firstGoalTime;

   private Double goalLine;
   private Double upperOdds;
   private Double  lowerOdds;

   private Double handicap;
   private Double homeOdds;
   private Double visitingOdds;

   private Double winOdds;
   private Double drawOdds;
   private Double lostOdds;

   private String homeTeamName;
   private String leagueName;
   private Integer totalGoal;
   private String visitingTeamName;
   private Integer halfHomeGoal;
   private Integer homeGoal;
   private Integer visitingGoal;

   private Integer midHomeGoal;
   private Integer midVisitingGoal;
   private Integer midGoal;

   private List<MongoGoalLineEntity> goalLineList;
   private List<MongoHandicapEntity> handicapList;
   private List<MongoWinDrawEntity> mongoWinDrawList;
   private List<MongoGoalEntity> mongoGoalList;
   private List<SimilarGameEntity> similarList;

  private boolean smallFlag=false;
  private boolean bigFlag=false;

  private String bigMessage;
  private String samllMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getGoalLine() {
        return goalLine;
    }

    public void setGoalLine(Double goalLine) {
        this.goalLine = goalLine;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }


    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }


    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getTotalGoal() {
        return totalGoal;
    }

    public void setTotalGoal(Integer totalGoal) {
        this.totalGoal = totalGoal;
    }


    public String getVisitingTeamName() {
        return visitingTeamName;
    }

    public void setVisitingTeamName(String visitingTeamName) {
        this.visitingTeamName = visitingTeamName;
    }

    public Integer getHalfHomeGoal() {
        return halfHomeGoal;
    }

    public void setHalfHomeGoal(Integer halfHomeGoal) {
        this.halfHomeGoal = halfHomeGoal;
    }


    public Integer getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(Integer homeGoal) {
        this.homeGoal = homeGoal;
    }

    public Integer getVisitingGoal() {
        return visitingGoal;
    }

    public void setVisitingGoal(Integer visitingGoal) {
        this.visitingGoal = visitingGoal;
    }

    public List<MongoGoalLineEntity> getGoalLineList() {
        return goalLineList;
    }

    public void setGoalLineList(List<MongoGoalLineEntity> goalLineList) {
        this.goalLineList = goalLineList;
    }

    public List<MongoHandicapEntity> getHandicapList() {
        return handicapList;
    }

    public void setHandicapList(List<MongoHandicapEntity> handicapList) {
        this.handicapList = handicapList;
    }

    public List<MongoWinDrawEntity> getMongoWinDrawList() {
        return mongoWinDrawList;
    }

    public void setMongoWinDrawList(List<MongoWinDrawEntity> mongoWinDrawList) {
        this.mongoWinDrawList = mongoWinDrawList;
    }

    public Integer getMidHomeGoal() {
        return midHomeGoal;
    }

    public void setMidHomeGoal(Integer midHomeGoal) {
        this.midHomeGoal = midHomeGoal;
    }

    public Integer getMidVisitingGoal() {
        return midVisitingGoal;
    }

    public void setMidVisitingGoal(Integer midVisitingGoal) {
        this.midVisitingGoal = midVisitingGoal;
    }

    public Integer getMidGoal() {
        return midGoal;
    }

    public void setMidGoal(Integer midGoal) {
        this.midGoal = midGoal;
    }

    public Double getUpperOdds() {
        return upperOdds;
    }

    public void setUpperOdds(Double upperOdds) {
        this.upperOdds = upperOdds;
    }

    public Double getLowerOdds() {
        return lowerOdds;
    }

    public void setLowerOdds(Double lowerOdds) {
        this.lowerOdds = lowerOdds;
    }

    public Double getHomeOdds() {
        return homeOdds;
    }

    public void setHomeOdds(Double homeOdds) {
        this.homeOdds = homeOdds;
    }

    public Double getVisitingOdds() {
        return visitingOdds;
    }

    public void setVisitingOdds(Double visitingOdds) {
        this.visitingOdds = visitingOdds;
    }

    public Double getWinOdds() {
        return winOdds;
    }

    public void setWinOdds(Double winOdds) {
        this.winOdds = winOdds;
    }

    public Double getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(Double drawOdds) {
        this.drawOdds = drawOdds;
    }

    public Double getLostOdds() {
        return lostOdds;
    }

    public void setLostOdds(Double lostOdds) {
        this.lostOdds = lostOdds;
    }

    public List<MongoGoalEntity> getMongoGoalList() {
        return mongoGoalList;
    }

    public void setMongoGoalList(List<MongoGoalEntity> mongoGoalList) {
        this.mongoGoalList = mongoGoalList;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public Integer getTimeSeq() {
        return timeSeq;
    }

    public void setTimeSeq(Integer timeSeq) {
        this.timeSeq = timeSeq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFirstGoalTime() {
        return firstGoalTime;
    }

    public void setFirstGoalTime(Integer firstGoalTime) {
        this.firstGoalTime = firstGoalTime;
    }

    public boolean isSmallFlag() {
        return smallFlag;
    }

    public void setSmallFlag(boolean smallFlag) {
        this.smallFlag = smallFlag;
    }

    public boolean isBigFlag() {
        return bigFlag;
    }

    public void setBigFlag(boolean bigFlag) {
        this.bigFlag = bigFlag;
    }

    public String getBigMessage() {
        return bigMessage;
    }

    public void setBigMessage(String bigMessage) {
        this.bigMessage = bigMessage;
    }

    public String getSamllMessage() {
        return samllMessage;
    }

    public void setSamllMessage(String samllMessage) {
        this.samllMessage = samllMessage;
    }

    public List<SimilarGameEntity> getSimilarList() {
        return similarList;
    }

    public void setSimilarList(List<SimilarGameEntity> similarList) {
        this.similarList = similarList;
    }
}
