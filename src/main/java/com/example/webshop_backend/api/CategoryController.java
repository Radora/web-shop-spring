/*
package com.example.webshop_backend.api;

import com.example.webshop_backend.model.Category;
import com.example.webshop_backend.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @PostMapping("/categories/new")
    public String addCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Integer id){
        //  Category category = categoryService.findById(id)
        //  .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id :" + id));
        categoryService.deleteCategory(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody @Valid Category categoryEdited){
        Category category = categoryService.findById(id)
        //Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new NullPointerException("Category does not exist with id :" + id));
        category.setName(categoryEdited.getName());
        Category updatedCategory = categoryService.updateCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }
}
*/
