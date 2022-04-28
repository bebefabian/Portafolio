package com.example.CRUD.Crud.Java.service;


import com.example.CRUD.Crud.Java.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category createCategory(Category category);
    Category findCategoryById(long id);
    Category updateCategory(long id, Category category);
    Long deleteCategory(long id);
}
