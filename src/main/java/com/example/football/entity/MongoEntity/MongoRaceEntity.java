package com.example.football.entity.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

//@Data
@Document(collection="goal")
public class MongoRaceEntity extends SimpleRaceEntity{
    @Id
   private String id;


   private List<MongoGoalLineEntity> goalLineList;
   private List<MongoHandicapEntity> handicapList;
   private List<MongoWinDrawEntity> mongoWinDrawList;
   private List<MongoGoalEntity> mongoGoalList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MongoGoalLineEntity> getGoalLineList() {
        return goalLineList;
    }

    public void setGoalLineList(List<MongoGoalLineEntity> goalLineList) {
        this.goalLineList = goalLineList;
    }

    public List<MongoHandicapEntity> getHandicapList() {
        return handicapList;
    }

    public void setHandicapList(List<MongoHandicapEntity> handicapList) {
        this.handicapList = handicapList;
    }

    public List<MongoWinDrawEntity> getMongoWinDrawList() {
        return mongoWinDrawList;
    }

    public void setMongoWinDrawList(List<MongoWinDrawEntity> mongoWinDrawList) {
        this.mongoWinDrawList = mongoWinDrawList;
    }

    public List<MongoGoalEntity> getMongoGoalList() {
        return mongoGoalList;
    }

    public void setMongoGoalList(List<MongoGoalEntity> mongoGoalList) {
        this.mongoGoalList = mongoGoalList;
    }
}
