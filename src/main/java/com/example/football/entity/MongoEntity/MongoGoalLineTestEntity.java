package com.example.football.entity.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
@Document(collection="goalLineTest")
public class MongoGoalLineTestEntity {
    @Id
   private String id;
    private String date;

    private String timeSeq;
    private Double goalLine;
    private Double upperOdds;
    private Double  lowerOdds;

    private Double handicap;
    private Double homeOdds;
    private Double visitingOdds;
    private String endTimeSeq;
    private Integer goalLinelValue;
    private Integer handicapValue;



    private Integer homeGoal;
    private Integer visitingGoal;
    private Integer totalGoal;

    private String HandicapResult;
    private String result;
    private String raceId;
    private String homeTeamName;
    private String visitingTeamName;
    private String leagueName;

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

    public String getTimeSeq() {
        return timeSeq;
    }

    public void setTimeSeq(String timeSeq) {
        this.timeSeq = timeSeq;
    }

    public Double getGoalLine() {
        return goalLine;
    }

    public void setGoalLine(Double goalLine) {
        this.goalLine = goalLine;
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

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
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

    public String getEndTimeSeq() {
        return endTimeSeq;
    }

    public void setEndTimeSeq(String endTimeSeq) {
        this.endTimeSeq = endTimeSeq;
    }

    public Integer getGoalLinelValue() {
        return goalLinelValue;
    }

    public void setGoalLinelValue(Integer goalLinelValue) {
        this.goalLinelValue = goalLinelValue;
    }

    public Integer getHandicapValue() {
        return handicapValue;
    }

    public void setHandicapValue(Integer handicapValue) {
        this.handicapValue = handicapValue;
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

    public Integer getTotalGoal() {
        return totalGoal;
    }

    public void setTotalGoal(Integer totalGoal) {
        this.totalGoal = totalGoal;
    }

    public String getHandicapResult() {
        return HandicapResult;
    }

    public void setHandicapResult(String handicapResult) {
        HandicapResult = handicapResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getVisitingTeamName() {
        return visitingTeamName;
    }

    public void setVisitingTeamName(String visitingTeamName) {
        this.visitingTeamName = visitingTeamName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
}
