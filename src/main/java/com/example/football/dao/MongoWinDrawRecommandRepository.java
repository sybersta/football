package com.example.football.dao;

import com.example.football.entity.MongoEntity.MongoHandicapRecommandEntity;
import com.example.football.entity.MongoEntity.MongoWinDrawRecommandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoWinDrawRecommandRepository extends MongoRepository<MongoWinDrawRecommandEntity, String> {
}
