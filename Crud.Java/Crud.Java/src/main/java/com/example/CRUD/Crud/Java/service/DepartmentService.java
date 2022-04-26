package com.example.CRUD.Crud.Java.service;

import com.example.CRUD.Crud.Java.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartment();
    Department createDepartment(Department department);
    Department findDepById(long id);
    Department updateDepartment(long id, Department department);
    long deleteDep(long id);

}
