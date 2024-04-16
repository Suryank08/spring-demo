package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//IN THIS EXAMPLE ALL COMPONENT SET AS LAZY USING PROPERITIES FILE GLOBALLY
@RestController
public class DemoController {
    //define a private field for the dependices inection
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        System.out.println("In Constructor" + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getdailyWorkout();
    }

}
