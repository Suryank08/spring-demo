package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependices inection
    private  Coach myCoach;

  /*
    @Autowired annotationFor dependency injection, Spring can use autowiring
    Spring will look for a class that matches by type: class or interface
    Spring will inject it automatically … hence it is autowired
    Injecting a Coach implementation
    Spring will scan for @Components

    //This is constructor DI approach
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach =theCoach;
//    }
*/


    //This is Setter DI using @Autowired Annotation
    // @Autowired annotion make SpringIOC container to scan Components(Beans)(@Component)( By making its object internally )
    // Make Ioc Container  Scan in the same package for Components Beans implicity
    @Autowired
    public void setCoach(Coach theCoach){
        this.myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getdailyWorkout();
    }

}
