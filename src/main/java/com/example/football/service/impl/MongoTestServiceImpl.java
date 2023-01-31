package com.example.football.service.impl;

import com.example.football.dao.MongoTestRepository;
import com.example.football.entity.MongoEntity.MongoTestEntity;
import com.example.football.service.MongoService;
import com.example.football.service.MongoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoTestServiceImpl implements MongoTestService {
    @Autowired
private MongoTestRepository mongoTestRepository;
    @Override
    public void saveRace(MongoTestEntity mongoTestEntity) {
        mongoTestRepository.save(mongoTestEntity);
    }
}
