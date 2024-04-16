package com.example.mappingdemo.dao;

import com.example.mappingdemo.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailDao extends JpaRepository<InstructorDetail , Integer> {
}
