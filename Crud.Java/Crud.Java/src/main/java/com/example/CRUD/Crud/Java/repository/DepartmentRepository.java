package com.example.CRUD.Crud.Java.repository;

import com.example.CRUD.Crud.Java.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
