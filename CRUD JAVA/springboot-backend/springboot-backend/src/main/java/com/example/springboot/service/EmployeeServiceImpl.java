package com.example.springboot.service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        String fullName = getFullName(employee);
        employee.setFullName(fullName);
        return employeeRepository.save(employee);
    }

    public String getFullName(Employee employee){
        return employee.getFirstName() + " " + employee.getLastName();
    }

}
