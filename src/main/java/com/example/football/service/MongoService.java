package com.example.football.service;

import com.example.football.entity.MongoEntity.MongoRaceEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface MongoService {
    public void saveRace(MongoRaceEntity mongoRaceEntity);
    public  void ins(Date date,int num) throws Exception;
    public Thread getNewThread(Date date) throws Exception;
    public List<MongoRaceEntity> getList();
}
