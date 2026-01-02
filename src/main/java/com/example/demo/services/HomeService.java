package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.HomeRepository;
import com.example.demo.model.Home;

@Service
public class HomeService {
	
	@Autowired
    private HomeRepository Repository;
	
	
	public Home addhome(Home h) {
		return this.Repository.save(h);
	}

	public List<Home> getAllHome() {
		return this.Repository.findAll();
	}


	

}
