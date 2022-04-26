package com.example.CRUD.Crud.Java.service;

import com.example.CRUD.Crud.Java.model.Department;
import com.example.CRUD.Crud.Java.model.Employee;
import com.example.CRUD.Crud.Java.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAllDepartment() { return departmentRepository.findAll(); }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepById(long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department updateDepartment(long id, Department department) {
        Department UpdateDepartment = departmentRepository.findById(id).get();

            UpdateDepartment.setDepartmentName(department.getDepartmentName());
            UpdateDepartment.setNumberOfEmployees(department.getNumberOfEmployees());
        return departmentRepository.save(UpdateDepartment);
    }

    @Override
    public long deleteDep(long id) {
        Department DeleteDepartment = departmentRepository.findById(id).get();
            departmentRepository.delete(DeleteDepartment);
        return DeleteDepartment.getId();
    }
}
