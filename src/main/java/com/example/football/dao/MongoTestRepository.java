package com.example.football.dao;

import com.example.football.entity.MongoEntity.MongoRaceEntity;
import com.example.football.entity.MongoEntity.MongoTestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoTestRepository extends MongoRepository<MongoTestEntity, String> {

}
