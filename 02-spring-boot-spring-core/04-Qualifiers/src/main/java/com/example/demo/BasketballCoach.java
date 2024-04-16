package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
    @Override
    public String getdailyWorkout() {
        return "this is daily Basketball workout!!!!!!!!!";
    }
}
