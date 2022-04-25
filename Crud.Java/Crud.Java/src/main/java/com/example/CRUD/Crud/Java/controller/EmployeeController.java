package com.example.CRUD.Crud.Java.controller;

import com.example.CRUD.Crud.Java.model.Employee;
import com.example.CRUD.Crud.Java.repository.EmployeeRepository;
import com.example.CRUD.Crud.Java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    //Build find all employees
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.findAllEmployee();
    }

    //Build Create an employee
    @PostMapping
    public Employee createAnEmployee(@RequestBody Employee employee) {
        Employee employeeCreated = employeeService.createEmployee(employee);
            return employeeCreated;
    }

    //Build Find employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id ) {
        Employee employeeById = employeeService.findEmployeeById(id);
            return ResponseEntity.ok(employeeById);
    }

    //Build UpdateEmployee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employeeDetails){
        Employee editEmployee = employeeService.updatedEmployee(id, employeeDetails);
            return ResponseEntity.ok(editEmployee);
    }

    //Build delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        long employeeDeleted = employeeService.DeleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
