package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependices inection
    private Coach myCoach;
//Here we have used @Primary annotation(it will acts as default implementation of interface and which is default one is he choose one by IOC spring Container)
    //So using there is no need of Use of qualifier the Object of CricketCaoch is injected in this example because it is declared as primary
    //So @primary Anoonated class is the deafault implemaentaion of interface in case of the multiple implemenation
    //But the using @Qualifier is the GOOD PRACTICE
    //there will not more than one @primary for an interface
    //@Qualifier has more priorty than @Primary
    @Autowired
    public DemoController(Coach theCoach)
            {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getdailyWorkout();
    }

}
