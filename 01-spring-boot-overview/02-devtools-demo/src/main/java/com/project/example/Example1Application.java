package com.project.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**************HERE WERE ARE USING----->spring-boot-devtools dependencies
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-devtools</artifactId>
 </dependency>
 IN POM XML TO LOAD PAGES DYNAMICALLY ON CHANGE IN JAVA CODE DIRECTLY WITHOUT REPETATIVE EXCEUTION/COMPILATION OF CODE
 AS IN PREVIOUS PROJECT ON CHANGES
 */

@SpringBootApplication
public class Example1Application {

	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);
	}

}
