package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Home;
import com.example.demo.services.HomeService;

@Controller
@RequestMapping("/Home")
@CrossOrigin(origins = "*") 
public class Homecontroller {
	
    @Autowired
    private HomeService services;

    @PostMapping("/addhome")
    @ResponseBody
    public Home addhome(@RequestBody Home h) {
        System.out.println(h);
        return this.services.addhome(h);
    }

    @GetMapping("/getallhome")
    @ResponseBody
    public List<Home> getAllHome() {
        return this.services.getAllHome();
    }

    @GetMapping("/forgot-password")
    public String showForgotPassword() {
        return "password"; // looks for password.html in templates/
    }
}
