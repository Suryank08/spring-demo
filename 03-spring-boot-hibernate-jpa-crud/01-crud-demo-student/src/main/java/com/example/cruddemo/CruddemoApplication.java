package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            //createStudent(studentDAO);
           // createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
           // updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);

        };

    }


    private void createStudent(StudentDAO studentDAO) {

        //create the student objects
        System.out.println("Creating new student objects....");
        Student tempStudent = new Student("Suryank", "Mishra", "Suryankmishra@34.com");

        //save the student object
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println("Saved id the student Generated id " + tempStudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //Creating Multiple Students
        Student tempStudent1 = new Student("Suryank", "Mishra", "Suryankmishra@34.com");
        Student tempStudent2 = new Student("Arin ", "Pandey", "Arin@189230");
        Student tempStudent3 = new Student("Mausa ", "Ji", "mausaji@34.com");
        Student tempStudent4 = new Student("Shahshi", "Mishra", "Shashimishra@34.com");
        Student tempStudent5 = new Student("bhujgendra", "Mishra", "Bhujgendarmishra@34.com");
        Student tempStudent6 = new Student("Aditi", "Mishra", "Aditimishra@34.com");
        List<Student> studentsList = new ArrayList<Student>();
        studentsList.add(tempStudent1);
        studentsList.add(tempStudent2);
        studentsList.add(tempStudent3);
        studentsList.add(tempStudent4);
        studentsList.add(tempStudent5);
        studentsList.add(tempStudent6);

        //save th multiple students;
        System.out.println("Svaing the multiple Students using List ");
        for (int i = 0; i < 6; i++) {
            studentDAO.save(studentsList.get(i));
        }
        //display id of saved students
        studentsList.forEach(student -> System.out.println(student.getId()));

    }

    public void readStudent(StudentDAO studentDAO) {

        //create a student onject
        System.out.println("crreating the new student objects");
        Student student = new Student("Suryank", "Mishra", "57");

        //display id of the the saved Student
        studentDAO.save(student);
        System.out.println("The id of the studenst" + student.getId());


        //retrive students on the basis of id:primary key
        Integer theID = student.getId();
        Student myStudent = studentDAO.findByID(theID);

        //display student
        System.out.println("Found the student ::" + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get List of Students
        List<Student> theStudentList = studentDAO.findAll();

        //Display the Lsit of the Students
        //theStudentList.forEach(System.out::println);
        theStudentList.forEach(Student -> System.out.println(Student));
    }
  public void queryForStudentsByLastName(StudentDAO studentDAO){
        List<Student> theStudents=studentDAO.findByLastName("Mishra");
        theStudents.forEach(System.out::println);
  }
  public void updateStudent(StudentDAO studentDAO){

        //reterving student based on the id :primary key
      int studentId=1;
      System.out.println("Getting student with id:"+studentId);
      Student student= studentDAO.findByID(studentId);

      //change thefirst name of the student to "kukku"
      System.out.println("updating the name");
      student.setFirstName("kukku");

      //update theh student
      studentDAO.update(student);

      //display the updated name
      System.out.println(studentDAO.findByID(studentId));
  }
  public void deleteStudent(StudentDAO studentDAO){
        int studentid =2;
      System.out.println("Deleting studnet id "+studentid);
        studentDAO.delete(studentid);
  }

  public void deleteAllStudents(StudentDAO studentDAO){
      System.out.println("Deleteing all students");
        int numberOfStudentsDeleted=studentDAO.deleteAll();
      System.out.println("The Number of Students get Deleted");
      System.out.println(numberOfStudentsDeleted);
  }
}

