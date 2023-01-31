package com.example.football.mapper;

import com.example.football.entity.GoalEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface GoalMapper {
public List<GoalEntity> getFirstGoalList(@Param(value="handicap")Double handicap,@Param(value="goalLine")Double goalLine);

}
