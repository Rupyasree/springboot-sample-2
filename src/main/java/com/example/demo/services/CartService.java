package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.productRepo;
import com.example.demo.model.Cart;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private productRepo productRepository; // ✅ inject product repo

    public Cart addToCart(Long productId, String productName, int quantity, String userId) {
        // 1️⃣ Find product from DB
        var product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 2️⃣ Check if already in cart
        Cart existingCart = cartRepository.findByProductIdAndUserId(productId, userId);
        if (existingCart != null) {
            existingCart.setQuantity(existingCart.getQuantity() + quantity);
            return cartRepository.save(existingCart);
        }

        // 3️⃣ Create new cart item
        Cart cartItem = new Cart();
        cartItem.setProductId(productId);
        cartItem.setProductName(product.getName());
        cartItem.setPrice(product.getPrice());   // ✅ set price correctly
        cartItem.setQuantity(quantity);
        cartItem.setUserId(userId);

        return cartRepository.save(cartItem);
    }

    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }

    public List<Cart> getCartItemsByUser(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
