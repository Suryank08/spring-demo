package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependices inection
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        myCoach = theCoach;
    }
//Here we have used @Qualifier notation to select between various implementation of Coach interfce.
    //Only first letter is small case in the @Qualifier annotation and rest will follow camel case

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getdailyWorkout();
    }

}
