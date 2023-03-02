package com.NMSCinemas.dto;

import java.util.Set;

import com.NMSCinemas.model.Address;
import com.NMSCinemas.model.TicketOrder;
import com.NMSCinemas.model.Tickets;
import com.NMSCinemas.model.User;

import lombok.Data;


@Data //Lombok annotation for getters/setters/etc,
public class TicketOrderDto {
	
    private User user;
    private Address shippingAddress;
    private Address billingAddress;
    private TicketOrder ticketOrder;
    private Set<Tickets> tickets;

}
