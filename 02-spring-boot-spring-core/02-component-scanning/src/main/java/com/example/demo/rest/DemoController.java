package com.example.demo.rest;

import com.example.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependices inection
    private Coach myCoach;
    @Autowired
    public DemoController(Coach theCoach){
        myCoach =theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getdailyWorkout();
    }

}
