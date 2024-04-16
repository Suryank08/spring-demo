package com.example.mappingdemo.service;

import com.example.mappingdemo.dao.CourseDao;
import com.example.mappingdemo.dao.InstructorDao;
import com.example.mappingdemo.entity.Courses;
import com.example.mappingdemo.entity.Instructor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private InstructorDao instructorDao;

    @Autowired
    private CourseDao courseDao;

    @Transactional
    public Courses saveByCourse(Courses courses) {
        try {
            System.out.println("All OKay");
            return courseDao.save(courses);
        } catch (NullPointerException e) {
            System.out.println("error");
            return courses;
        }
    }

    @Transactional
    public Instructor save(Instructor instructor) {

        try {
            System.out.println("All OKay");
            return instructorDao.save(instructor);
        } catch (NullPointerException e) {
            System.out.println("error");
            return instructor;
        }
    }

    @Override
    public Optional<Instructor> findById(Integer id) {
        return instructorDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        instructorDao.deleteById(id);
    }

}
