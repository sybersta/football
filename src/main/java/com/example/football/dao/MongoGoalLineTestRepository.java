package com.example.football.dao;

import com.example.football.entity.MongoEntity.MongoGoalLineTestEntity;
import com.example.football.entity.MongoEntity.MongoTestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoGoalLineTestRepository extends MongoRepository<MongoGoalLineTestEntity, String> {

}
