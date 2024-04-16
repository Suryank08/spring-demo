package com.example.mappingdemo.dao;

import com.example.mappingdemo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDao extends JpaRepository<Instructor,Integer> {
}