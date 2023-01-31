package com.example.football.service;

import com.example.football.entity.HandicapAnalysisEntity;

public interface HandicapService {
    HandicapAnalysisEntity hand1(String handicapTableName, String goalLineTableName, String id);
}
