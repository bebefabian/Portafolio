package com.example.CRUD.Crud.Java.service;

import com.example.CRUD.Crud.Java.model.Category;
import com.example.CRUD.Crud.Java.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() { return categoryRepository.findAll(); }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(long id, Category category) {
        Category editCategory = categoryRepository.findById(id).get();

        editCategory.setCategoryName(category.getCategoryName());
        editCategory.setActiveStatus(category.getActiveStatus());

        return categoryRepository.save(editCategory);
    }

    @Override
    public Long deleteCategory(long id) {
        Category eraseCat = categoryRepository.findById(id).get();
            categoryRepository.delete(eraseCat);

        return eraseCat.getId();
    }
}
