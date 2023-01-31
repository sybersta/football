package com.example.football.Congfiguration;

import com.example.football.service.RecommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Slf4j
//@Order(value = 1)

public class StartLoader implements ApplicationRunner {
    @Autowired
    RecommandService recommandService ;
    @Override
    public void run(ApplicationArguments args){
        try {
            recommandService.startScann();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
