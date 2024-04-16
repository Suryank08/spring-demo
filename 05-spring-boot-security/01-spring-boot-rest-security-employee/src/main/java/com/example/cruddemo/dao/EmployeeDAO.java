package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
   public  List<Employee> findAll();
   Employee findById(int theId);
   void deleteById(int theId);

   Employee save(Employee theEmployee);
}
