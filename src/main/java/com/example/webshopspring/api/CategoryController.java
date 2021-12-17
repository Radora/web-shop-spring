package com.example.webshopspring.api;

import com.example.webshopspring.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    @GetMapping
    public List<Category> getAllCategories(){

        return Arrays.asList(
                new Category(1, "Smartphones"),
                new Category(2, "Notebooks"),
                new Category(3, "Desktop PC's")
        );
    }

    @PostMapping
    public String addCategory(){
        return "Category added";
    }

    @DeleteMapping
    public String deleteCategory(){
        return "Category deleted";
    }

    @PutMapping
    public String updateCategory(){
        return "Category data updated";
    }

}
