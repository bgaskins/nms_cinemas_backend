package com.NMSCinemas.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NMSCinemas.dto.TicketOrderDto;
import com.NMSCinemas.dto.TicketOrderResponse;
import com.NMSCinemas.service.CartService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cart")
public class CartController {

	   private CartService cartService;

	    public CartController(CartService cartService) {
	        this.cartService = cartService;
	    }

	    @PostMapping("/order")
	    public TicketOrderResponse makeOrder(@RequestBody TicketOrderDto order) {
	        TicketOrderResponse orderResponse = cartService.placeOrder(order);
	        // Receives TicketOrderResponse from TicketOrderDTO
	        return orderResponse;
	    }

}

