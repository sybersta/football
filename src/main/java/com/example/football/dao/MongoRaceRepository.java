package com.example.football.dao;

import com.example.football.entity.MongoEntity.MongoRaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRaceRepository extends MongoRepository<MongoRaceEntity, String> {
    @Query("{" +
            "$and: [{" +
            "        'mongoWinDrawList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?0," +
            "        'visitingGoal':?1," +
            "        'homeGoal':?2," +
            "        'winOdds':?3," +
            "        'drawOdds':?4," +
            "        'lostOdds':?5" +
            "            }" +
            "             }" +
            "    },{" +
            "        'mongoWinDrawList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?6," +
            "        'visitingGoal':?7," +
            "        'homeGoal':?8," +
            "        'winOdds':?9," +
            "        'drawOdds':?10," +
            "        'lostOdds':?11" +
            "            }" +
            "        }" +
            "    }]" +
            "  }")
    List<MongoRaceEntity> findWinDrawList(String timeSeq1,Integer visitingGoal1,Integer homeGoal1,
                                          Double winOdds1,Double drawOdds1,Double lostOdds1,
                                          String timeSeq2,Integer visitingGoal2,Integer homeGoal2,
                                          Double winOdds2,Double drawOdds2,Double lostOdds2);

    @Query("{" +
            "$and: [{" +
            "        'goalLineList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?0," +
            "        'visitingGoal':?1," +
            "        'homeGoal':?2," +
            "        'lowerOdds':?3," +
            "        'upperOdds':?4," +
            "        'goalLine':?5" +
            "            }" +
            "        }" +
            "    }," +
            "{" +
            "        'handicapList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?6," +
            "        'visitingGoal':?7," +
            "        'homeGoal':?8," +
//            "        'homeOdds':?9," +
//            "        'visitingOdds':?10," +
            "        'handicap':?11" +
            "            }" +
            "        }" +
            "    }," +
            "{" +
            "        'handicapList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?12," +
            "        'visitingGoal':?13," +
            "        'homeGoal':?14," +
//            "        'homeOdds':?15," +
//            "        'visitingOdds':?16," +
            "        'handicap':?17" +
            "            }" +
            "        }" +
            "    }," +
            "{" +
            "        'goalLineList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?18," +
            "        'visitingGoal':?19," +
            "        'homeGoal':?20," +
            "        'lowerOdds':?21," +
            "        'upperOdds':?22," +
            "        'goalLine':?23" +
            "            }" +
            "        }" +
            "    }]" +
            "  }")
    List<MongoRaceEntity> findGoalLineList(String timeSeq1,Integer visitingGoal1,Integer homeGoal1,
                                           Double lowerOdds1,Double upperOdds1,Double goalLine1,
                                           String timeSeq2,Integer visitingGoal2,Integer homeGoal2,
                                           Double homeOdds2,Double visitingOdds2,Double handicap2,
                                           String timeSeq4,Integer visitingGoal4,Integer homeGoal4,
                                           Double homeOdds4,Double visitingOdds4,Double handicap4,
                                           String timeSeq3,Integer visitingGoal3,Integer homeGoal3,
                                           Double lowerOdds3,Double upperOdds3,Double goalLine3);


    @Query("{" +
            "$and: [{" +
            "        'goalLineList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?0," +
            "        'visitingGoal':?1," +
            "        'homeGoal':?2," +
//            "        'lowerOdds':?3," +
//            "        'upperOdds':?4," +
            "        'goalLine':?5" +
            "            }" +
            "        }" +
            "    }," +
            "{" +
            "        'handicapList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?6," +
            "        'visitingGoal':?7," +
            "        'homeGoal':?8," +
            "        'homeOdds':?9," +
            "        'visitingOdds':?10," +
            "        'handicap':?11" +
            "            }" +
            "        }" +
            "    }," +
            "{" +
            "        'handicapList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?12," +
            "        'visitingGoal':?13," +
            "        'homeGoal':?14," +
            "        'homeOdds':?15," +
            "        'visitingOdds':?16," +
            "        'handicap':?17" +
            "            }" +
            "        }" +
            "    }," +
            "{" +
            "        'goalLineList': {" +
            "            '$elemMatch': {" +
            "                'timeSeq': ?18," +
            "        'visitingGoal':?19," +
            "        'homeGoal':?20," +
//            "        'lowerOdds':?21," +
//            "        'upperOdds':?22," +
            "        'goalLine':?23" +
            "            }" +
            "        }" +
            "    }]" +
            "  }")
    List<MongoRaceEntity> findHandicapList(String timeSeq1,Integer visitingGoal1,Integer homeGoal1,
                                           Double lowerOdds1,Double upperOdds1,Double goalLine1,
                                           String timeSeq2,Integer visitingGoal2,Integer homeGoal2,
                                           Double homeOdds2,Double visitingOdds2,Double handicap2,
                                           String timeSeq4,Integer visitingGoal4,Integer homeGoal4,
                                           Double homeOdds4,Double visitingOdds4,Double handicap4,
                                           String timeSeq3,Integer visitingGoal3,Integer homeGoal3,
                                           Double lowerOdds3,Double upperOdds3,Double goalLine3);

    @Query("{\n" +
            "$or:[" +
//            "{'date':{$regex:?0}},\n" +
//            "{'date':{$regex:?1}},\n" +
            "{'date':{$regex:?2}}\n" +
            "]\n" +
            "}")
    List<MongoRaceEntity> findAllList(String var1,String var2,String var3);

}
