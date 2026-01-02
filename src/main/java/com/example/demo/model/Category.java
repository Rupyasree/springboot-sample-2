package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String details;

    public Category() {}

    public Category(String name,String details) {
        this.name = name;
    }
    
    public String getdetails() {
    	return details; }
    public void setdetails(String details) { this.details = details; }
    
    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
