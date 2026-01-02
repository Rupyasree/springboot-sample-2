package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Login;
import com.example.demo.services.EmailService;
import com.example.demo.services.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/home")
    public String login(@RequestBody Login loginRequest) {
        String username = loginRequest.getUsername().trim();
        String password = loginRequest.getPassword().trim();
        String email = loginRequest.getEmail();

        if (loginService.checkLogin(username, password)) {
            emailService.sendEmail(
                email,
                "Login Successful - SkyCart",
                "Hi " + username + ",\n\nYou have successfully logged in to SkyCart."
            );
            return "Login successful. Email sent to: " + email;
        } else {
            return "Login failed. Invalid username or password.";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody Login login) {
        Login savedLogin = loginService.registerUser(login);
        return "User registered with ID: " + savedLogin.getId();
    }
}
