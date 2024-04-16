package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Lazy annotation make bean load only when they are required
// during Dependencies injection and Call.
public class BasketballCoach implements Coach {
    @Override
    public String getdailyWorkout() {
        return "this is daily Basketball workout!!!!!!!!!";
    }

    public BasketballCoach() {
        System.out.println("In Constructor" + getClass().getSimpleName());
    }
}
