package com.example.thymeleafdemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

@Controller
public class HelloWorldController {
    //need a controller method to show intial HTML fgorm
    @GetMapping("/showForm")
public String showForm(){
        //this will return name of html of file which will render on this request
    return "helloworld-form";
}
//need a controller method to process the HTML form
@GetMapping("/processForm")
    public String processForm(){
    //this will return name of html of file which will render on this request

    return "helloWorld";
}
//need a controller method to read form data and
    //add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request , Model model){
        //read the requesr pararmeter from the HTML form
       String theName= request.getParameter("studentName");

        theName=theName.toUpperCase();

        String result ="YO"+theName;

        model.addAttribute("message",result);
        return "helloWorld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model){
        //read the requesr pararmeter from the HTML form

        theName=theName.toUpperCase();

        String result ="Hey my Friend"+theName;

        model.addAttribute("message",result);
        return "helloWorld";
    }
}
