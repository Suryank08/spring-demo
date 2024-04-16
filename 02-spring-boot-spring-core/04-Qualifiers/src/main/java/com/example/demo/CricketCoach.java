package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getdailyWorkout() {
        return "this is daily Cricketworkout!!!!!!!!!";
    }
}
