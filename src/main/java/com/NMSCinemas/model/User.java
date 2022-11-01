package com.NMSCinemas.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long user;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "email")
	private String email;


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TicketOrder> ticketOrders = new HashSet<>();

    public void add(TicketOrder ticketOrder) {

        if (ticketOrder != null) {

            if (ticketOrders == null) {
                ticketOrders = new HashSet<>();
            }

            ticketOrders.add(ticketOrder);
            ticketOrder.setUser(this);
        }
    }
	
}