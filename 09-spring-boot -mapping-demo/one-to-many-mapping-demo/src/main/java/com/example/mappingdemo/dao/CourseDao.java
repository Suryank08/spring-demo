package com.example.mappingdemo.dao;

import com.example.mappingdemo.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Courses,Integer> {
}
