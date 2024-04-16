package com.project1.example1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FunRestController {
    @GetMapping("/user")
    public String hello(){
       int x=01;
        return "Alloha!!!\nThis is Suryank Mishra is number one and only"+x;
    }
}
