package com.example.CRUD.Crud.Java.service;

import com.example.CRUD.Crud.Java.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee createEmployee(Employee employee);
    Employee findEmployeeById(long id);
    Employee updatedEmployee(long id, Employee employee);
    long DeleteEmployee(long id);

}
