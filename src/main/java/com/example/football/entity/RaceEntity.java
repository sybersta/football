package com.example.football.entity;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.Date;
//@Data
public class RaceEntity {
   private String id;
   private Date date;
   private Double goalLine;
   private Double handicap;
   private String homeTeam;
   private String homeTeamName;
   private String league;
   private String leagueName;
   private Integer totalGoal;
   private String visitingTeam;
   private String visitingTeamName;
   private Double corner;
   private Integer halfHomeCorner;
   private Integer halfHomeGoal;
   private Integer halfVisitingCorner;
   private Integer halfVisitingGoal;
   private Integer homeCorner;
   private Integer homeGoal;
   private Integer visitingCorner;
   private Integer visitingGoal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getGoalLine() {
        return goalLine;
    }

    public void setGoalLine(Double goalLine) {
        this.goalLine = goalLine;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public String getVisitingTeamName() {
        return visitingTeamName;
    }

    public void setVisitingTeamName(String visitingTeamName) {
        this.visitingTeamName = visitingTeamName;
    }

    public Double getCorner() {
        return corner;
    }

    public void setCorner(Double corner) {
        this.corner = corner;
    }

    public Integer getHalfHomeCorner() {
        return halfHomeCorner;
    }

    public void setHalfHomeCorner(Integer halfHomeCorner) {
        this.halfHomeCorner = halfHomeCorner;
    }

    public Integer getHalfHomeGoal() {
        return halfHomeGoal;
    }

    public void setHalfHomeGoal(Integer halfHomeGoal) {
        this.halfHomeGoal = halfHomeGoal;
    }

    public Integer getHalfVisitingCorner() {
        return halfVisitingCorner;
    }

    public void setHalfVisitingCorner(Integer halfVisitingCorner) {
        this.halfVisitingCorner = halfVisitingCorner;
    }

    public Integer getHalfVisitingGoal() {
        return halfVisitingGoal;
    }

    public void setHalfVisitingGoal(Integer halfVisitingGoal) {
        this.halfVisitingGoal = halfVisitingGoal;
    }

    public Integer getHomeCorner() {
        return homeCorner;
    }

    public void setHomeCorner(Integer homeCorner) {
        this.homeCorner = homeCorner;
    }

    public Integer getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(Integer homeGoal) {
        this.homeGoal = homeGoal;
    }

    public Integer getVisitingCorner() {
        return visitingCorner;
    }

    public void setVisitingCorner(Integer visitingCorner) {
        this.visitingCorner = visitingCorner;
    }

    public Integer getVisitingGoal() {
        return visitingGoal;
    }

    public void setVisitingGoal(Integer visitingGoal) {
        this.visitingGoal = visitingGoal;
    }
}
