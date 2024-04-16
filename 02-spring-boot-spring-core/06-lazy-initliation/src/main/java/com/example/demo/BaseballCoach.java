package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getdailyWorkout() {
        return "this is baseballdaily workout!!!!!!!!!";
    }

    public BaseballCoach() {
        System.out.println("In Constructor"+getClass().getSimpleName());
    }
}
