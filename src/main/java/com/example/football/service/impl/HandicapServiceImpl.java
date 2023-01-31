package com.example.football.service.impl;

import com.example.football.entity.HandicapAnalysisEntity;
import com.example.football.mapper.HandicapAnalysisMapper;
import com.example.football.mapper.HandicapMapper;
import com.example.football.service.HandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandicapServiceImpl implements HandicapService {
@Autowired
    HandicapMapper handicapMapper;
    @Override
    public HandicapAnalysisEntity hand1(String handicapTableName, String goalLineTableName, String id) {
        return handicapMapper.hand1(handicapTableName,goalLineTableName,id);
    }
}
