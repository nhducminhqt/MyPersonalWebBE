package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(long categoryId, Category category) {
        return null;
    }

    @Override
    public Category deleteCategory(long id) {
        return categoryRepository.getReferenceById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return null;
    }
}
