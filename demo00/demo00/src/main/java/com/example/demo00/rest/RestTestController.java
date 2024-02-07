package com.example.demo00.rest;

import com.example.demo00.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    // constructor injection
    private Coach coach;
    private Coach swimmer;
    private Coach coach2;
    @Autowired
    public RestTestController(@Qualifier("aquatic")Coach coach, @Qualifier("aquatic") Coach swimmer) {
        this.coach = coach;
        this.swimmer = swimmer;
    }

    // setter injection
    @Autowired
    public void doSomething(@Qualifier("cricketCoach") Coach theCoach){
        this.coach2=theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();

    }

}
