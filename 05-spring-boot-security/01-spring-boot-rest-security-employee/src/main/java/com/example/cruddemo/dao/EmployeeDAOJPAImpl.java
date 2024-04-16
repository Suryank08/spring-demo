package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        //exceute Query
        List<Employee> employeeList = theQuery.getResultList();
        //return list
        return employeeList;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee =entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
         Employee theEmployee=entityManager.find(Employee.class,theId);
         entityManager.remove(theEmployee);
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);
        return dbEmployee;

    }


}
