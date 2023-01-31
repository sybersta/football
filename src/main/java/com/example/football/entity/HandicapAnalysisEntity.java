package com.example.football.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//@Data
@TableName("t_first_goal_analysis")
public class HandicapAnalysisEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer league;

    private String race;

    private Integer handicapTimeSeq;

    private Integer goalLineTimeSeq;

    private Integer homeGoal;

    private Integer visitingGoal;

    private Integer totalGoal;

    private Double originHandicap;

    private Double currentHandicap;

    private Double originGoalLine;

    private Double currentGoalLine;

    private Double result;

    private Double goalLineResult;

    private String matchResult;

    private String matchGoalLineResult;

    private Date time;

    private Integer team;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeague() {
        return league;
    }

    public void setLeague(Integer league) {
        this.league = league;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getHandicapTimeSeq() {
        return handicapTimeSeq;
    }

    public void setHandicapTimeSeq(Integer handicapTimeSeq) {
        this.handicapTimeSeq = handicapTimeSeq;
    }

    public Integer getGoalLineTimeSeq() {
        return goalLineTimeSeq;
    }

    public void setGoalLineTimeSeq(Integer goalLineTimeSeq) {
        this.goalLineTimeSeq = goalLineTimeSeq;
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

    public Double getOriginHandicap() {
        return originHandicap;
    }

    public void setOriginHandicap(Double originHandicap) {
        this.originHandicap = originHandicap;
    }

    public Double getCurrentHandicap() {
        return currentHandicap;
    }

    public void setCurrentHandicap(Double currentHandicap) {
        this.currentHandicap = currentHandicap;
    }

    public Double getOriginGoalLine() {
        return originGoalLine;
    }

    public void setOriginGoalLine(Double originGoalLine) {
        this.originGoalLine = originGoalLine;
    }

    public Double getCurrentGoalLine() {
        return currentGoalLine;
    }

    public void setCurrentGoalLine(Double currentGoalLine) {
        this.currentGoalLine = currentGoalLine;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getGoalLineResult() {
        return goalLineResult;
    }

    public void setGoalLineResult(Double goalLineResult) {
        this.goalLineResult = goalLineResult;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getMatchGoalLineResult() {
        return matchGoalLineResult;
    }

    public void setMatchGoalLineResult(String matchGoalLineResult) {
        this.matchGoalLineResult = matchGoalLineResult;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }
}
