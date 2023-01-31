package com.example.football.entity;

public class SimilarGameEntity {
    private String homeTeamName;
    private String masterTeamName;
    private Double handicap;
    private String time;
    private String guestTeamName;
    private String score;
    private String gameName;

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getMasterTeamName() {
        return masterTeamName;
    }

    public void setMasterTeamName(String masterTeamName) {
        this.masterTeamName = masterTeamName;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
