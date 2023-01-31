package com.example.football.dao;

import com.example.football.entity.MongoEntity.MongoGoalLineRecommandEntity;
import com.example.football.entity.MongoEntity.MongoRaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoGoalLineRecommandRepository extends MongoRepository<MongoGoalLineRecommandEntity, String> {
}
