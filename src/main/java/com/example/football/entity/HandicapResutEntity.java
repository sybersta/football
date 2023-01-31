package com.example.football.entity;

public class HandicapResutEntity {
    private Integer winAll;
    private Integer winHalf;
    private Integer draw;
    private Integer loseHalf;
    private Integer loseAll;
    private Double handicap;

    public Integer getWinAll() {
        return winAll;
    }

    public void setWinAll(Integer winAll) {
        this.winAll = winAll;
    }

    public Integer getWinHalf() {
        return winHalf;
    }

    public void setWinHalf(Integer winHalf) {
        this.winHalf = winHalf;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLoseHalf() {
        return loseHalf;
    }

    public void setLoseHalf(Integer loseHalf) {
        this.loseHalf = loseHalf;
    }

    public Integer getLoseAll() {
        return loseAll;
    }

    public void setLoseAll(Integer loseAll) {
        this.loseAll = loseAll;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }
}
