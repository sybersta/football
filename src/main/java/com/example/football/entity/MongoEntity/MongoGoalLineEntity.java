package com.example.football.entity.MongoEntity;

import java.util.Date;

public class MongoGoalLineEntity {
    private String id;
    private Integer homeGoal;
    private Integer visitingGoal;

    private String time;
    private String timeSeq;

    private Double goalLine;
    private Double lowerOdds;
    private Double upperOdds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(Integer homeGoal) {
        this.homeGoal = homeGoal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeSeq() {
        return timeSeq;
    }

    public void setTimeSeq(String timeSeq) {
        this.timeSeq = timeSeq;
    }

    public Integer getVisitingGoal() {
        return visitingGoal;
    }

    public void setVisitingGoal(Integer visitingGoal) {
        this.visitingGoal = visitingGoal;
    }

    public Double getGoalLine() {
        return goalLine;
    }

    public void setGoalLine(Double goalLine) {
        this.goalLine = goalLine;
    }

    public Double getLowerOdds() {
        return lowerOdds;
    }

    public void setLowerOdds(Double lowerOdds) {
        this.lowerOdds = lowerOdds;
    }

    public Double getUpperOdds() {
        return upperOdds;
    }

    public void setUpperOdds(Double upperOdds) {
        this.upperOdds = upperOdds;
    }
}
