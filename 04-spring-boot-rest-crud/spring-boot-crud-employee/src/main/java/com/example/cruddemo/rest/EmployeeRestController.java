package com.example.cruddemo.rest;

import com.example.cruddemo.service.EmployeeService;
import com.example.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    //quick and dirty :inject EmployeeService(Constructor injection)
@Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService= employeeService;
    }
    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee>findAll(){
    return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
   Employee theEmployee= employeeService.findById(employeeId);
   if(theEmployee==null){
       throw new RuntimeException("Employee id not found-->"+employeeId);

   }
   return theEmployee;
    }
    //Add Mapping for post /employees -add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
    //also just in case they pass an id in json ... set id to 0
        //this is to force a save of item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);

    return dbEmployee;
    }
    //add mapping for PUT /employees -update existing employees
    @PutMapping("/employees")
    public Employee updateEmployees(@RequestBody Employee theEmployee){
    Employee dbEmployee = employeeService.save(theEmployee);
    return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
     Employee tempEmployee = employeeService.findById(employeeId);
     if (tempEmployee==null){
         throw new RuntimeException("Employee id not found-->"+employeeId);
     }
    employeeService.deleteById(employeeId);
     return "Deleted employee id-->"+employeeId;
    }



  @GetMapping("/hii")
    public String hello(){
    return "hello";
  }


}
