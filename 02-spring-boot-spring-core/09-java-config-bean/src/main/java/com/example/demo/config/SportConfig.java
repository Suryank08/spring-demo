package com.example.demo.config;

import com.example.demo.Coach;
import com.example.demo.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
@Configuration
public class SportConfig {
    //Name of the method become id of the @Bean b default
    //@Bean can be provided by custom id explicilty( @Bean("aquatic"))
    @Bean
//    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }


}
