package com.nagarro.ecommerce.ecom.controller;

import com.nagarro.ecommerce.ecom.entity.CartItem;
import com.nagarro.ecommerce.ecom.entity.Product;
import com.nagarro.ecommerce.ecom.repository.CartItemRepository;
import com.nagarro.ecommerce.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    // Fetch all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Add a product to the cart
    @PostMapping("/cart")
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // Fetch all items in the cart
    @GetMapping("/cart")
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }
}
