package com.example.football.entity.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Data
@Document(collection="test")
public class MongoTestEntity {
    @Id
   private String id;
    private String date;

    private String timeSeq;
    private Double goalLine;
    private Double upperOdds;
    private Double  lowerOdds;

    private String timeSeq1;
    private Double goalLine1;
    private Double upperOdds1;
    private Double lowerOdds1;

    private String handicapTimeSeq;
    private Double handicap;
    private Double homeOdds;
    private Double visitingOdds;

    private String handicapTimeSeq1;
    private Double handicap1;
    private Double homeOdds1;
    private Double visitingOdds1;

    private Integer homeGoal;
    private Integer visitingGoal;
    private Integer totalGoal;

    private Integer homeGoal1;
    private Integer homeGoal2;
    private Integer visitingGoal1;
    private Integer visitingGoal2;

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

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
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

    public Double getGoalLine1() {
        return goalLine1;
    }

    public void setGoalLine1(Double goalLine1) {
        this.goalLine1 = goalLine1;
    }

    public Double getUpperOdds1() {
        return upperOdds1;
    }

    public void setUpperOdds1(Double upperOdds1) {
        this.upperOdds1 = upperOdds1;
    }

    public Double getLowerOdds1() {
        return lowerOdds1;
    }

    public void setLowerOdds1(Double lowerOdds1) {
        this.lowerOdds1 = lowerOdds1;
    }

    public Double getHandicap1() {
        return handicap1;
    }

    public void setHandicap1(Double handicap1) {
        this.handicap1 = handicap1;
    }

    public Double getVisitingOdds1() {
        return visitingOdds1;
    }

    public void setVisitingOdds1(Double visitingOdds1) {
        this.visitingOdds1 = visitingOdds1;
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

    public Double getHomeOdds1() {
        return homeOdds1;
    }

    public void setHomeOdds1(Double homeOdds1) {
        this.homeOdds1 = homeOdds1;
    }

    public Double getVisitingOdds() {
        return visitingOdds;
    }

    public void setVisitingOdds(Double visitingOdds) {
        this.visitingOdds = visitingOdds;
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

    public String getTimeSeq() {
        return timeSeq;
    }

    public void setTimeSeq(String timeSeq) {
        this.timeSeq = timeSeq;
    }

    public String getTimeSeq1() {
        return timeSeq1;
    }

    public void setTimeSeq1(String timeSeq1) {
        this.timeSeq1 = timeSeq1;
    }

    public String getHandicapTimeSeq() {
        return handicapTimeSeq;
    }

    public void setHandicapTimeSeq(String handicapTimeSeq) {
        this.handicapTimeSeq = handicapTimeSeq;
    }

    public String getHandicapTimeSeq1() {
        return handicapTimeSeq1;
    }

    public void setHandicapTimeSeq1(String handicapTimeSeq1) {
        this.handicapTimeSeq1 = handicapTimeSeq1;
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

    public Integer getHomeGoal1() {
        return homeGoal1;
    }

    public void setHomeGoal1(Integer homeGoal1) {
        this.homeGoal1 = homeGoal1;
    }

    public Integer getHomeGoal2() {
        return homeGoal2;
    }

    public void setHomeGoal2(Integer homeGoal2) {
        this.homeGoal2 = homeGoal2;
    }

    public Integer getVisitingGoal1() {
        return visitingGoal1;
    }

    public void setVisitingGoal1(Integer visitingGoal1) {
        this.visitingGoal1 = visitingGoal1;
    }

    public Integer getVisitingGoal2() {
        return visitingGoal2;
    }

    public void setVisitingGoal2(Integer visitingGoal2) {
        this.visitingGoal2 = visitingGoal2;
    }
}
