package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class BaseballCoach implements Coach {
    public BaseballCoach() {

        System.out.println("In Constructor" + getClass().getSimpleName());
    }
    //define our initialization method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In my doMyStartupStuff()-->"+getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("In my doMyCleanStuff()-->"+getClass().getSimpleName());
    }

    @Override
    public String getdailyWorkout() {
        return "this is baseballdaily workout!!!!!!!!!";
    }
}
