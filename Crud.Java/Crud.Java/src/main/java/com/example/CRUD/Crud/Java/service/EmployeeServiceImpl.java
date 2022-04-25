package com.example.CRUD.Crud.Java.service;

import com.example.CRUD.Crud.Java.model.Employee;
import com.example.CRUD.Crud.Java.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() { return employeeRepository.findAll(); }

    @Override
    public Employee createEmployee(Employee employee) {
        String fullName = getFullName(employee);
        employee.setFullName(fullName);
            return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updatedEmployee(long id, Employee employee) {

        Employee UpdateEmployee = employeeRepository.findById(id).get();

        UpdateEmployee.setFirstName(employee.getFirstName());
        UpdateEmployee.setLastName(employee.getLastName());
        UpdateEmployee.setFullName(employee.getFullName());
        UpdateEmployee.setEmailId(employee.getEmailId());

        return employeeRepository.save(employee);

    }

    @Override
    public long DeleteEmployee(long id) {
        Employee employeeDeleted = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeDeleted);
        return employeeDeleted.getId();
    }

    public String getFullName(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName();
    }
}
