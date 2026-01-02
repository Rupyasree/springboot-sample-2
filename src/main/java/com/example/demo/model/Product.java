package com.example.demo.model;
import com.example.demo.model.Category; // ✅ correct


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Product {
    
    public Product(Long id, String name, double price, String category, String description, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	
		this.description = description;
		this.imagePath = imagePath;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
   
    private String description;

    // For simplicity, we’ll store image name (not full file)
    private String imagePath;
    
    @ManyToOne
    @JoinColumn(name = "category_id") // foreign key
    private Category category;

	public Product(Long id, String name, double price, String description, String imagePath, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.category = category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
