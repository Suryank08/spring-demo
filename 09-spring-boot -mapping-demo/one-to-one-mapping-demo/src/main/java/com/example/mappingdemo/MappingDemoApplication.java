package com.example.mappingdemo;

import com.example.mappingdemo.entity.Instructor;
import com.example.mappingdemo.entity.InstructorDetail;
import com.example.mappingdemo.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class MappingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppService service) {
        return runner -> {
           createInstructor(service);
		//	findInstructor(service);
        //    deleteInstructorById(service);
          //    updateInstructorNameUsingId(service);


        };
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

    private void createInstructor(AppService service) {


        Instructor instructor = new Instructor("shashi", 45);

        InstructorDetail instructorDetail = new InstructorDetail("house-work", "ba");

        instructor.setInstructorDetail(instructorDetail);

        //for explicity putting value of foreign key from instructor primary key join
//       instructor.addInstructorDetail(instructorDetail);

       //Saving using Instructor Details
        Instructor instructor1 = new Instructor("poonam", 45);

        InstructorDetail instructorDetail1 = new InstructorDetail("house-work", "mba");

        instructorDetail1.setInstructor(instructor1);

        service.save(instructor);

        //saving using Instructor Details
        service.saveInstructorDetail(instructorDetail1);

        System.out.println("Done");
    }

    private void findInstructor(AppService service) {
        Integer id =3;
        Optional<Instructor> optionalInstructor= service.findById(id);
        try {
            Instructor tempInstructor = optionalInstructor.get();
            System.out.println("Printing the Instructor"+tempInstructor);
            System.out.println("Printing the Instructor"+tempInstructor.getInstructorDetail());
        }
        catch (Exception e){
            System.out.println("No Instructor is Found");
            e.printStackTrace();
        }

    }

}
