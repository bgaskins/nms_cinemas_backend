package com.NMSCinemas.service;

import com.NMSCinemas.dto.TicketOrderDto;
import com.NMSCinemas.dto.TicketOrderResponse;

public interface CartService {

		  TicketOrderResponse placeOrder(TicketOrderDto ticketOrderDto);
		  
}
