package com.example.emaildemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendLoginEmail(String toEmail, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Login Alert - Your Account");
        message.setText("Hi " + username + ",\n\nYou have successfully logged in.\n\nRegards,\nYour Website Team");
        mailSender.send(message);
        System.out.println("✅ Login email sent to " + toEmail);
    }
}
