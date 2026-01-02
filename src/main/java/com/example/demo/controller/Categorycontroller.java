package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.services.CategoryService;



@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class Categorycontroller {

    @Autowired
    private CategoryService categoryService;

    // Add single category
    @PostMapping("/addcategory")
    public Category addcategory(@RequestBody Category c) {
        return this.categoryService.addcategory(c);
    }

    // Add multiple categories
    @PostMapping("/addcategories")
    public List<Category> addCategories(@RequestBody List<Category> categories) {
        return categoryService.addAll(categories);
    }

    // ✅ Get all categories (this is the one you need for Postman)
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
