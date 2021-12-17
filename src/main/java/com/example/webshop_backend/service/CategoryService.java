package com.example.webshop_backend.service;

import com.example.webshop_backend.model.Category;
import com.example.webshop_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
    public Category updateCategory(Category category){
        categoryRepository.save(category);
        return category;
    }
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
    public Optional<Category> findById(int id){
        return categoryRepository.findById(id);
    }
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
