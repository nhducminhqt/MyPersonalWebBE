package com.example.demo.services;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.models.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(long categoryId,CategoryDTO categoryDTO);
    String deleteCategory(long id);
    List<Category> getAllCategories();
    Category getCategoryById(long id);
}
