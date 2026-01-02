package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoginRepository;
import com.example.demo.model.Login;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean checkLogin(String username, String password) {
        Login user = loginRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public Login registerUser(Login login) {
        return loginRepository.save(login);
    }
}
