package com.crud.demo.rest;

import java.util.List;
import java.util.ArrayList;

import com.crud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the Stdent data... only once!

    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Suryank","Mishra"));
        theStudents.add(new Student("Shashi","Mishra"));
        theStudents.add(new Student("Adit","Mishra"));


    }
    //define the endpoints of the students
    @GetMapping("/students")
    public List<Student> getStudents() {
        //define the all Studnets here is not a good practice
//        List<Student> studentList=new ArrayList<Student>();
//        studentList.add(new Student("Suryank","Mishra"));
//        studentList.add(new Student("Dharmendra","Pandey"));
//        studentList.add(new Student("Aditi","Mishra"));
        return theStudents;

    }

    //define end point or "/students/{studentId}' -return studnet at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list ... keep it simple forr now

        //check the studentId again list size
        if((studentId>=theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("Student Not Found with id number"+studentId);
        }
        return  theStudents.get(studentId);
    }



}
