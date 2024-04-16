package com.example.mappingdemo;

import com.example.mappingdemo.entity.Courses;
import com.example.mappingdemo.entity.Instructor;
import com.example.mappingdemo.entity.InstructorDetail;
import com.example.mappingdemo.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MappingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppService service) {
        return runner -> {
           createCourseInstructor(service);
		//	findInstructor(service);
        //    deleteInstructorById(service);
          //    updateInstructorNameUsingId(service);


        };
    }

    private void createCourseInstructor(AppService service) {
        Instructor tempInstructor1 = new Instructor("shashi", 45);
        Instructor tempInstructor2 = new Instructor("poonam", 39);
        Instructor tempInstructor3 = new Instructor("Dharmendra", 40);


        Courses course1 = new Courses("Maths",200);
        Courses course2 = new Courses("English",300);
        Courses course3 = new Courses("programming",500);
        Courses course4 = new Courses("Biology",700);

        tempInstructor1.addInstructorCourses(course1);
        tempInstructor1.addInstructorCourses(course2);
        tempInstructor2.addInstructorCourses(course3);
        tempInstructor3.addInstructorCourses(course4);
        //saving the instructor
        service.save(tempInstructor1);
        service.save(tempInstructor2);
        service.save(tempInstructor3);
        System.out.println("Done");
    }

    private void updateInstructorNameUsingId(AppService service) {
        Integer id =2;
        Optional<Instructor> optionalInstructor= service.findById(id);
        try {
            Instructor tempInstructor = optionalInstructor.get();
            tempInstructor.setName("Suryank");
            service.save(tempInstructor);
            System.out.println("Deleting the Instructor"+tempInstructor );
        }
        catch (Exception e){
            System.out.println("No Instructor is Found");
            e.printStackTrace();
        }
    }

    private void deleteInstructorById(AppService service) {
        Integer id =3;
        Optional<Instructor> optionalInstructor= service.findById(id);
        try {
            Instructor tempInstructor = optionalInstructor.get();
            service.deleteById(id);
            System.out.println("Deleting the Instructor"+tempInstructor );
        }
        catch (Exception e){
            System.out.println("No Instructor is Found");
            e.printStackTrace();
        }
    }

    private void findInstructor(AppService service) {
        Integer id =2;
        Optional<Instructor> optionalInstructor= service.findById(id);
        try {
            Instructor tempInstructor = optionalInstructor.get();
            System.out.println("Printing the Instructor"+tempInstructor);
            System.out.println("Printing the Instructor");
            tempInstructor.getInstructorCourses().forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println("No Instructor is Found");
            e.printStackTrace();
        }

    }

}
