package com.example.football.entity;

public class GoalLineResutEntity {
    private Integer winAll;
    private Integer winHalf;
    private Integer draw;
    private Integer loseHalf;
    private Integer loseAll;
    private Double goalLine;

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

    public Double getGoalLine() {
        return goalLine;
    }

    public void setGoalLine(Double goalLine) {
        this.goalLine = goalLine;
    }
}
