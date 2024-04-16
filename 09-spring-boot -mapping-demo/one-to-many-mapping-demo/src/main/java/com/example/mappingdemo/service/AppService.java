package com.example.mappingdemo.service;

import com.example.mappingdemo.entity.Instructor;

import java.util.Optional;

public interface AppService {
    public Instructor save(Instructor instructor);

    public Optional<Instructor> findById(Integer id);

    public void deleteById(Integer id);
}


