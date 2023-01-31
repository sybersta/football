package com.example.football.dao;

import com.example.football.entity.MongoEntity.MongoGoalLineRecommandEntity;
import com.example.football.entity.MongoEntity.MongoHandicapRecommandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoHandicapRecommandRepository extends MongoRepository<MongoHandicapRecommandEntity, String> {
}
