package com.example.springboot.service;

import com.example.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee createEmployee(Employee employee);
    Employee findEmployeeById(long id);
}


