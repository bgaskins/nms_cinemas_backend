package com.NMSCinemas.service;

import com.NMSCinemas.dto.TicketOrderDto;
import com.NMSCinemas.dto.TicketOrderResponse;

public interface CartService {
	// Places an order by taking a ticket order DTO and returning a ticket order response.
	TicketOrderResponse placeOrder(TicketOrderDto ticketOrderDto);
		  
}
