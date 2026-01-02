package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.productRepo;

import com.example.demo.model.Product;

@Service
public class productServices {
	
@Autowired
private  productRepo Repository;


	public Product addproduct(Product p) {
		// TODO Auto-generated method stub
		return Repository.save(p);
	}

	public List<Product> getallProducts() {
		// TODO Auto-generated method stub
		return Repository.findAll();
	}
	
	public Product getProductById(Long id) {
		return this.Repository.findById(id).orElse(null); 
	}

	 public List<Product> searchProducts(String keyword) {
	        return Repository.searchProducts(keyword);
	    }


	

}
