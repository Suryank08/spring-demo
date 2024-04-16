package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//injecting EmployeeRepository
 private EmployeeRepository employeeRepository;
 @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
     this. employeeRepository= employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not fid employee");

        }
        return theEmployee;
    }
@Transactional
    @Override
    public Employee save(Employee theEmployee) {
       return employeeRepository.save(theEmployee);
    }

@Transactional
    @Override
    public void deleteById(int theId) {
 employeeRepository.deleteById(theId);
    }
}
