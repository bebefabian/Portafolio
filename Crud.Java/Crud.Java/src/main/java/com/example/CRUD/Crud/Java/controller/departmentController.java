package com.example.CRUD.Crud.Java.controller;

import com.example.CRUD.Crud.Java.model.Department;
import com.example.CRUD.Crud.Java.repository.DepartmentRepository;
import com.example.CRUD.Crud.Java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/department")
public class departmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @PostMapping
    public Department createDep(@RequestBody Department department) {
         Department createdDep = departmentService.createDepartment(department);
            return createdDep;
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> depById(@PathVariable("id") long id) {
        Department depById = departmentService.findDepById(id);
        return ResponseEntity.ok(depById);
    }

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDep(@PathVariable("id") long id, @RequestBody Department departmentDetails){
        Department editDep = departmentService.updateDepartment(id, departmentDetails);
        return ResponseEntity.ok(editDep);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable long id) {
        long delDepartment = departmentService.deleteDep(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
