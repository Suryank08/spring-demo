package com.example.mappingdemo;

import com.example.mappingdemo.entity.Courses;
import com.example.mappingdemo.entity.Instructor;
import com.example.mappingdemo.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MappingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppService service) {
        return runner -> {
            createCourseInstructor(service);
        };
    }

    private void createCourseInstructor(AppService service) {
        Instructor tempInstructor1 = new Instructor("shashi", 45);
        Instructor tempInstructor2 = new Instructor("poonam", 39);
        Instructor tempInstructor3 = new Instructor("Dharmendra", 40);


        Courses course1 = new Courses("Maths", 200);
        Courses course2 = new Courses("English", 300);
        Courses course3 = new Courses("programming", 500);
        Courses course4 = new Courses("biology", 500);


        //setting up instructor List in Courses
        List<Instructor> instructorList1 = List.of(tempInstructor1, tempInstructor3);
        course1.setInstructorsList(instructorList1);

        List<Instructor> instructorList2 = List.of(tempInstructor1);
        course2.setInstructorsList(instructorList2);

        List<Instructor> instructorList3 = List.of(tempInstructor2);
        course3.setInstructorsList(instructorList3);

        //setting up coursesList in Instructor
        List<Courses> coursesList1 = List.of(course1, course2);
        tempInstructor1.setInstructorCourses(coursesList1);

        List<Courses> coursesList2 = List.of(course3);
        tempInstructor2.setInstructorCourses(coursesList2);

        List<Courses> coursesList3 = List.of(course1);
        tempInstructor3.setInstructorCourses(coursesList3);


        //Another Way(Check Notes)!!!!!
        //adding mutilple instructor in courses
        //use with convience method
//        course1.addInstructor(tempInstructor1);
//        course1.addInstructor(tempInstructor3);
//        course2.addInstructor(tempInstructor1);
//        course3.addInstructor(tempInstructor2);
//
//        //adding multiple courses in instructor
//        tempInstructor1.addInstructorCourses(course1);
//        tempInstructor1.addInstructorCourses(course2);
//        tempInstructor2.addInstructorCourses(course3);
//        tempInstructor3.addInstructorCourses(course1);

        //saving the tempInstructor
        service.save(tempInstructor1);
        service.save(tempInstructor2);
        service.save(tempInstructor3);
        System.out.println("Done");
    }


}
