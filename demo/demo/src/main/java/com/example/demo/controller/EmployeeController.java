package com.example.demo.controller;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class EmployeeController {

@Autowired
private EmployeeRepository employeeRepository;

@Autowired
private EmployeeService employeeService;




}
