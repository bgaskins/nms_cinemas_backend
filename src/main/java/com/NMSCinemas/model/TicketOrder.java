package com.NMSCinemas.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class TicketOrder {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;

	    @Column(name="order_tracking_number")
	    private String orderTrackingNumber;

	    @Column(name="total_quantity")
	    private int totalQuantity;

	    @Column(name="ticket_price")
	    private BigDecimal ticket_price;

	    @Column(name="status")
	    private String status;

	    @Column(name="date_created")
	    @CreationTimestamp
	    private Date dateCreated;

	    @Column(name="last_updated")
	    @UpdateTimestamp
	    private Date lastUpdated;

	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketOrder")
	    private Set<Tickets> tickets = new HashSet<>();

	    @ManyToOne
	    @JoinColumn(name = "userId")
	    private User user;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
	    private Address shippingAddress;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
	    private Address billingAddress;

	    public void add(Tickets ticket) {

	        if (ticket != null) {
	            if (tickets == null) {
	                tickets = new HashSet<>();
	            }

	            tickets.add(ticket);
	            ticket.setTicketOrder(this);
	        }
	    }
}
