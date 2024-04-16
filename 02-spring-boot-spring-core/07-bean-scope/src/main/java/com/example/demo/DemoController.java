package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach theAnotherCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach,
                          @Qualifier("baseballCoach") Coach theAnotherCoach) {
        System.out.println("In Constructor" + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.theAnotherCoach = theAnotherCoach;
        System.out.println("Comparing the beans :myCoach==theAnotherCoach:::" + (myCoach == theAnotherCoach));

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getdailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing the beans :myCoach==theAnotherCoach------>" + (myCoach == theAnotherCoach);
    }

}
