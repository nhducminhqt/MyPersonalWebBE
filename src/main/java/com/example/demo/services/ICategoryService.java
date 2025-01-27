package com.example.demo.services;

import com.example.demo.models.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(Category category);
    Category updateCategory(long categoryId,Category category);
    Category deleteCategory(long id);
    List<Category> getAllCategories();
    Category getCategoryById(long id);
}
