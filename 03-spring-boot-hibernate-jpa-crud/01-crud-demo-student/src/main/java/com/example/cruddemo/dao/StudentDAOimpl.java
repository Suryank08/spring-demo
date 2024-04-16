package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO {
    //define for entity mananger
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /*@Transactional is an annotation used to define the scope of a database transaction.
    This annotation can be applied to methods, classes, or interfaces.
     When you mark a method with @Transactional, Spring ensures that the method is executed within a transaction.
      If the method completes successfully, the transaction is committed. If an exception occurs, the transaction is rolled back.*/
    //implements the save method
    //This is imporatnt --->
    //This annotation is used when we modify(update)  in database like opertion create() and update() and delete()
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }


    @Override
    @Transactional
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
       theQuery.setParameter("theData",theLastName);
       return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
   entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        //retriving the student
        Student student= entityManager.find(Student.class,id);
       //the delete the student
        entityManager.remove(student);
    }
    @Override
    @Transactional
    public int deleteAll(){
        int numRowsDeleted= entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
