package com.example.demo;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("In the constructor-->"+getClass().getSimpleName());
    }

    @Override
    public String getdailyWorkout() {
        return "Swin 100 meter as a warm up";
    }
}
