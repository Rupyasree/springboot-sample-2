package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.Product;

import java.util.List;

public interface productRepo extends JpaRepository<Product, Long> {
    // Search by name or category
	@Query("SELECT p FROM Product p " +
		       "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
		       "   OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
		       "   OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
		List<Product> searchProducts(@Param("keyword") String keyword);

    
    // Find products by category
    List<Product> findByCategory_NameIgnoreCase(String name);

    // Find by product name
    List<Product> findByNameContainingIgnoreCase(String name);





	List<Product> findByCategory_Id(Long id);



}

