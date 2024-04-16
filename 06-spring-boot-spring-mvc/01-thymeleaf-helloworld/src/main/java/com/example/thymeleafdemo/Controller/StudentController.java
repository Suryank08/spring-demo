package com.example.thymeleafdemo.Controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class StudentController {
    //add the of languages from properties file
    @Value("${languages}")
    private List<String> languages;

    //add the list of countries from the properties file
    @Value("${countries}")
    private List<String> countries;
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        //create the new student object
        Student theStudent =new Student();
        //add student object to the model
        theModel.addAttribute("student",theStudent);


        //Or we can directly use this-->
        //theModel.addAttribute("student", new Student());

        //add the List of countries to the model
        theModel.addAttribute("countries",countries);

        //add the List of languages to the model
        theModel.addAttribute("languages",languages);

        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String procesStudentForm(@ModelAttribute("student") Student theStudent){
        //log the input data
        System.out.println("theStudent-->"+theStudent.getFirstName()+"  "+theStudent.getLastName()+"  "+theStudent.getCountry());


        return "student-confirmation";
    }



}
