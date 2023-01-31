package com.example.football.entity;

public class GoalEntity {
    private Integer id;
    private String race;
    private Integer team;
    private Integer time;
    private Integer currentGoal;
    private Integer currentTotalGoal;
    private Integer seq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCurrentGoal() {
        return currentGoal;
    }

    public void setCurrentGoal(Integer currentGoal) {
        this.currentGoal = currentGoal;
    }

    public Integer getCurrentTotalGoal() {
        return currentTotalGoal;
    }

    public void setCurrentTotalGoal(Integer currentTotalGoal) {
        this.currentTotalGoal = currentTotalGoal;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
