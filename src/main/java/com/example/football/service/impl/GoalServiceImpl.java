package com.example.football.service.impl;

import com.example.football.entity.GoalEntity;
import com.example.football.mapper.GoalMapper;
import com.example.football.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService{
@Autowired
    GoalMapper goalMapper;
    @Override
    public List<GoalEntity> getFistGoalList(Double handicap, Double goalLine) {
        return goalMapper.getFirstGoalList(handicap,goalLine);
    }
}
