package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findByID(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    void update(Student student);
    void delete(Integer id);
    int deleteAll();

}
