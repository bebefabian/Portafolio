package com.example.springboot.service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee createEmployee(Employee employee) {
        String fullName = getFullName(employee);
        employee.setFullName(fullName);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.getById(id);
    }

    public String getFullName(Employee employee){
        return employee.getFirstName() + " " + employee.getLastName();
    }




}
