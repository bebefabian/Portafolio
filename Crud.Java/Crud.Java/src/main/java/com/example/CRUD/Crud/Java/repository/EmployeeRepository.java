package com.example.CRUD.Crud.Java.repository;

import com.example.CRUD.Crud.Java.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
