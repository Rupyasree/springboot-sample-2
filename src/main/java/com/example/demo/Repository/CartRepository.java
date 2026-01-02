package com.example.demo.Repository;

import com.example.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(String userId);

	Cart findByProductIdAndUserId(Long productId, String userId);
    
}
