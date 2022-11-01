package com.NMSCinemas.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.NMSCinemas.dto.TicketOrderDto;
import com.NMSCinemas.dto.TicketOrderResponse;
import com.NMSCinemas.model.TicketOrder;
import com.NMSCinemas.model.Tickets;
import com.NMSCinemas.model.User;
import com.NMSCinemas.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {
	  
	private UserRepository userRepository;

	    public CartServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @Override
	    @Transactional
	    public TicketOrderResponse placeOrder(TicketOrderDto ticketOrderDto) {

	        // retrieve the order info from dto
	        TicketOrder ticketOrder = ticketOrderDto.getTicketOrder();

	        // generate tracking number
	        String orderTrackingNumber = generateOrderTrackingNumber();
	        ticketOrder.setOrderTrackingNumber(orderTrackingNumber);

	        // populate order with orderItems
	        Set<Tickets> tickets = ticketOrderDto.getTickets();
	        tickets.forEach(ticket -> ticketOrder.add(ticket));

	        // populate order with billingAddress and shippingAddress
	        ticketOrderDto.setBillingAddress(ticketOrderDto.getBillingAddress());
	        ticketOrderDto.setShippingAddress(ticketOrderDto.getShippingAddress());

	        // populate customer with order
	        User user = ticketOrderDto.getUser();
	        user.add(ticketOrder);

	        // save to the database
	        userRepository.save(user);

	        // return a response
	        return new TicketOrderResponse(orderTrackingNumber);
	    }

	    private String generateOrderTrackingNumber() {

	        // generate a random UUID number (UUID version-4)
	        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
	        //
	        return UUID.randomUUID().toString();
	    }
}
