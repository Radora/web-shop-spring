package com.example.webshop_backend.api;

import com.example.webshop_backend.model.Product;
import com.example.webshop_backend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }
    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productService.findById(id);
    }
    @PostMapping("/products/new")
    public String addProduct(@RequestBody @Valid Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Integer id){
        //  Product product = ProductService.findById(id)
        //  .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id :" + id));
        productService.deleteProduct(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productEdited){
        Product product = productService.findById(id)
        //Product product = userRepository.findById(id)
        .orElseThrow(() -> new NullPointerException("Product does not exist with id :" + id));
        product.setCategory(productEdited.getCategory());
        product.setName(productEdited.getName());
        product.setDescription(productEdited.getDescription());
        product.setPrice(productEdited.getPrice());
        product.setProduct_stock(productEdited.getProduct_stock());
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }


}
