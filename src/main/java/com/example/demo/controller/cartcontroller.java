package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.productRepo;
import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.services.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart") // lowercase for consistency
public class cartcontroller {

    @Autowired
    private CartService cartService;

    @Autowired
    private productRepo productRepository;

    // ===================== Add item to cart =====================
    @PostMapping("/add")
    public Cart addToCart(
            @RequestParam Long productId,
            @RequestParam(defaultValue = "1") int quantity,
            @RequestParam(defaultValue = "guest") String userId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return cartService.addToCart(productId, product.getName(), quantity, userId);
    }

    // ===================== Get all cart items =====================
    @GetMapping("/all")
    public List<Cart> getCartItems() {
        return cartService.getCartItems();
    }

    // ===================== Get cart items for a specific user =====================
    @GetMapping("/user/{userId}")
    public List<Cart> getCartByUser(@PathVariable String userId) {
        return cartService.getCartItemsByUser(userId);
    }

    // ===================== Remove a single item =====================
    @DeleteMapping("/remove/{cartId}")
    public String removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
        return "Item removed from cart!";
    }

  
}
