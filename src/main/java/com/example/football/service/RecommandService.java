package com.example.football.service;

import com.example.football.entity.MongoEntity.MongoRaceEntity;

import java.util.List;

public interface RecommandService {
    public void startScann() throws Exception;

    public List<MongoRaceEntity> findAll();
}
