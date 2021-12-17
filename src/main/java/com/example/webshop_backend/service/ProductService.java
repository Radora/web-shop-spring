package com.example.webshop_backend.service;

import com.example.webshop_backend.model.Product;
import com.example.webshop_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public Product updateProduct(Product product){
        productRepository.save(product);
        return product;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

}
