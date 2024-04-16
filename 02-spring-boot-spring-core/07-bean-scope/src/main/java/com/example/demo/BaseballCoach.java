package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//Singleton is by default scope for a bean
//Making the Scope of bean prototype using @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {
    @Override
    public String getdailyWorkout() {
        return "this is baseballdaily workout!!!!!!!!!";
    }

    public BaseballCoach() {
        System.out.println("In Constructor"+getClass().getSimpleName());
    }
}
