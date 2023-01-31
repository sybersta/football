package com.example.football.entity.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Data
@Document(collection="handicap")
public class MongoHandicapRecommandEntity {
    @Id
   private String id;
   private String date;
   private String raceId;

   private Double handicap;
   private Double homeOdds;
   private Double visitingOdds;
   private String homeTeamName;
   private String leagueName;
   private Integer totalGoal;
   private String visitingTeamName;
   private Integer homeGoal;
   private Integer visitingGoal;

   private List<SimpleRaceEntity> raceList;

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

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public List<SimpleRaceEntity> getRaceList() {
        return raceList;
    }

    public void setRaceList(List<SimpleRaceEntity> raceList) {
        this.raceList = raceList;
    }
}
