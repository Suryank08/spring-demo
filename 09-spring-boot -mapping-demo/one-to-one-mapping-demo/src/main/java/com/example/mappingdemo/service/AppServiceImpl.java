package com.example.mappingdemo.service;

import com.example.mappingdemo.dao.InstructorDao;
import com.example.mappingdemo.dao.InstructorDetailDao;
import com.example.mappingdemo.entity.Instructor;
import com.example.mappingdemo.entity.InstructorDetail;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppServiceImpl implements AppService{
    @Autowired
    private InstructorDao instructorDao;

    @Autowired
    private InstructorDetailDao instructorDetailDao;
    @Transactional
    @Override
    public Instructor save(Instructor instructor){
        try{
            System.out.println("All OKay");
            return instructorDao.save(instructor);}
        catch (NullPointerException e){
            System.out.println("error");
            return instructor;
        }
    }

    @Transactional
    @Override
    public InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail){
        try{
            System.out.println("All OKay");
            return instructorDetailDao.save(instructorDetail);}
        catch (NullPointerException e){
            System.out.println("error");
            return instructorDetail;
        }
    }
    @Override
    public Optional<Instructor> findById(Integer id){
       return instructorDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Integer id){
        instructorDao.deleteById(id);
    }

}
