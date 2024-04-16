package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class BaseballCoach implements Coach {
    public BaseballCoach() {

        System.out.println("In Constructor" + getClass().getSimpleName());
    }

    @Override
    public String getdailyWorkout() {
        return "this is baseballdaily workout!!!!!!!!!";
    }
}
