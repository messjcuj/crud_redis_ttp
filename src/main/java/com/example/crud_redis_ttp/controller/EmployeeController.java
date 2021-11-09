package com.example.crud_redis_ttp.controller;


import com.example.crud_redis_ttp.entity.Employee;
import com.example.crud_redis_ttp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeRepository.saveEmployee(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Integer id){

        return employeeRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Employee employee){

        employeeRepository.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        employeeRepository.delete(id);
    }

}
