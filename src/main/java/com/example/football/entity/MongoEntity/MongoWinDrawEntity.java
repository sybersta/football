package com.example.football.entity.MongoEntity;

import java.util.Date;

public class MongoWinDrawEntity {
    private String id;
    private Integer homeGoal;
    private Integer visitingGoal;

    private String timeSeq;
    private String time;

    private Double winOdds;
    private Double drawOdds;
    private Double lostOdds;


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
}
