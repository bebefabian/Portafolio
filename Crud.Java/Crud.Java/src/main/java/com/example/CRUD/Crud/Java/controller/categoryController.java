package com.example.CRUD.Crud.Java.controller;


import com.example.CRUD.Crud.Java.model.Category;
import com.example.CRUD.Crud.Java.repository.CategoryRepository;
import com.example.CRUD.Crud.Java.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/category")
public class categoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> allCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping
    public Category createCategories(@RequestBody Category category) {
        Category catCreated = categoryService.createCategory(category);
        return catCreated;
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> catById(@PathVariable("id") long id) {
        Category catById = categoryService.findCategoryById(id);
        return ResponseEntity.ok(catById);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> editCategory (@PathVariable("id") long id, @RequestBody Category categoryDetails) {
        Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> eraseCategory(@PathVariable("id") long id) {
        long delCategory = categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
