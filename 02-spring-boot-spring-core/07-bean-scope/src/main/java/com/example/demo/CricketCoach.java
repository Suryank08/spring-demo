package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getdailyWorkout() {
        return "this is daily Cricketworkout!!!!!!!!!";
    }

    public CricketCoach() {
        System.out.println("In Constructor"+getClass().getSimpleName());
    }
}
