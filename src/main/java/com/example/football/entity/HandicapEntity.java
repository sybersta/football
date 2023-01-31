package com.example.football.entity;

import java.util.Date;

public class HandicapEntity {
    private Integer id;
    private Integer court;
    private Integer homeGoal;
    private String race;
    private Date time;
    private Integer timeSeq;
    private Integer visitingGoal;
    private Double handicap;
    private Double homeOdds;
    private Double visitingOdds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourt() {
        return court;
    }

    public void setCourt(Integer court) {
        this.court = court;
    }

    public Integer getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(Integer homeGoal) {
        this.homeGoal = homeGoal;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getTimeSeq() {
        return timeSeq;
    }

    public void setTimeSeq(Integer timeSeq) {
        this.timeSeq = timeSeq;
    }

    public Integer getVisitingGoal() {
        return visitingGoal;
    }

    public void setVisitingGoal(Integer visitingGoal) {
        this.visitingGoal = visitingGoal;
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
}
