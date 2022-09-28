package com.NMSCinemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NMSCinemas.model.Cart;
import com.NMSCinemas.repository.CartRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/all")
	public List<Cart> getAllTickets() {
		return cartRepository.findAll();
	}
	
	@PostMapping("/add")
	public Cart addToCart(@RequestBody(required = false) Cart cart) {
		return cartRepository.save(cart);
	}
	
	@DeleteMapping("/update/{id}")
	public void deleteFromCart(@PathVariable Long id) {
		cartRepository.deleteById(id);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteCart() {
		cartRepository.deleteAll();
	}
}

