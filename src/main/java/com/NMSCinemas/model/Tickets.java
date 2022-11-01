package com.NMSCinemas.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tickets")
@Getter
@Setter
public class Tickets {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;

	    @Column(name="image_url")
	    private String imageUrl;

	    @Column(name="ticket_price")
	    private BigDecimal ticket_price;

	    @Column(name="quantity")
	    private int quantity;

	    @Column(name="ticket_id")
	    private Long ticketId;

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private TicketOrder ticketOrder;
}
