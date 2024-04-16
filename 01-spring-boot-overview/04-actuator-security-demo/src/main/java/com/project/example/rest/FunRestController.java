package com.project.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**************HERE WERE ARE USING----->spring-boot-devtools dependencies
<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-devtools</artifactId>
 </dependency>
 IN POM XML TO LOAD PAGES DYNAMICALLY ON CHANGE IN JAVA CODE DIRECTLY WITHOUT REPETATIVE EXCEUTION/COMPILATION OF CODE
 AS IN PREVIOUS PROJECT ON CHANGES
 */
@RestController()
public class FunRestController {
    @GetMapping("/user")
    public String hello(){
       int x=01;
        return "Alloha!!!\nThis is Suryank Mishra is number one and only"+x;
    }
    @GetMapping("/details")
    public String details(){
        return "this will return details ";
    }
    @GetMapping("/rollnumber")
    public String rollNumber(){
        return "this will return roll number ";
    }

}
