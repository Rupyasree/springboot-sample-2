package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.productRepo;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.services.productServices;

@RestController
@RequestMapping("/products")
@CrossOrigin("*") // Allow frontend to call API
public class ProductController {

    @Autowired
    private productRepo Repository;
    
    @Autowired
    private productServices productService;

    // ✅ Add product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return Repository.save(product);
    }

    // ✅ Get all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return Repository.findAll();
    }

    // ✅ Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return Repository.findById(id).orElse(null);
    }
   
    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }
    
   
    // Search by category
    @GetMapping("/category/{name}")
    public List<Product> getByCategory(@PathVariable String name) {
        return Repository.findByCategory_NameIgnoreCase(name);
    }
    @GetMapping("/category/id/{id}")
    public List<Product> getProductsByCategoryId(@PathVariable Long id) {
        return Repository.findByCategory_Id(id);
    }

}
