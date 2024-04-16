package com.project.example.rest;

import org.springframework.beans.factory.annotation.Value;
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
    //inject properties for:student.name and college.name
    @Value("${student.name}")
    private String studentName;
    @Value("${college.name}")
    private String collegeName;
//expose new endpoints for "studentinfo"
    @GetMapping("/studentinfo")
    public String getStudentInfo(){
        return "Student Name:-"+studentName+"College Name:-"+collegeName;
    }

    @GetMapping("/user")
    public String hello(){
        return "Alloha Student!!!\nThis is Suryank Mishra is number one and only";
    }
    @GetMapping("/details")
    public String details(){
        return "this will return details of Student";
    }
    @GetMapping("/rollnumber")
    public String rollNumber(){
        return "this will return roll number 2200430100057";
    }

}
