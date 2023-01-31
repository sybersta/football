package com.example.football.mapper;

import com.example.football.entity.HandicapAnalysisEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HandicapMapper {
    public HandicapAnalysisEntity hand1(@Param(value="handicapTabeleName")String handicapTabeleName, @Param(value="goalLineTableName")String GoalLineTabeleName, @Param(value="id")String id);
}
