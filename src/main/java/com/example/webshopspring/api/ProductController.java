package com.example.webshopspring.api;

import com.example.webshopspring.model.Product;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts(){
        return Arrays.asList(
                new Product(1,"Iphone 8", "Iphone 8 description", new BigDecimal("599.99"), 8),
                new Product(2,"Samsung S8", "Samsung S8 description", new BigDecimal("499.99"), 11),
                new Product(3,"Huawei P40", "Huawei P40 description", new BigDecimal("449.99"), 9),
                new Product(4,"MacBook Pro", "MacBook description", new BigDecimal("1199.99"), 7)
        );
    }

    @PostMapping
    public String addProduct(){
        return "Product added";
    }

    @DeleteMapping
    public String deleteProduct(){
        return "Product deleted";
    }

    @PutMapping
    public String updateProduct(){
        return "Product data updated";
    }

}
