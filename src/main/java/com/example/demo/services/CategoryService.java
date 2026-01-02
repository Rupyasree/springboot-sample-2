package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CategoryRepository;
import com.example.demo.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	// Add single category
	public Category addcategory(Category c) {
		return repository.save(c);
	}

	// Add multiple categories
	public List<Category> addAll(List<Category> categories) {
		return repository.saveAll(categories); // ✅ Fix: save instead of findAll
	}

	// Get all categories
	public List<Category> getAllCategories() {
		return repository.findAll();
	}
}
