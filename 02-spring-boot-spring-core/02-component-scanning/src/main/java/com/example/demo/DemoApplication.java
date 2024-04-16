package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//explicitly mentioning dependencies
// because dependencies  is not in the same package of DemoApplication(this class)
@SpringBootApplication(
        scanBasePackages = {"com.example.demo", "com.example.util"}
)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
