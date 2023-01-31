package com.example.football.service;

import com.example.football.entity.GoalEntity;

import java.util.List;

public interface GoalService {
    //获取第一个进球的时间以及球队
List<GoalEntity> getFistGoalList(Double handicap,Double goalLine);
}
