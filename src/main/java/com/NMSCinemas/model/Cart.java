package com.NMSCinemas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "show_date")
	private String show_date;

	@Column(name = "show_time")
	private String show_time;
	
	@Column(name = "auditorium")
	private String auditorium;
	
	@Column(name = "ticket_price")
	private Long ticket_price;
	
	public Cart() {
	}

	public Cart(String title, String show_date, String show_time, String auditorium, Long ticket_price) {
		super();
		this.title = title;
		this.show_date = show_date;
		this.show_time = show_time;
		this.auditorium = auditorium;
		this.ticket_price = ticket_price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShow_date() {
		return show_date;
	}

	public void setShow_date(String show_date) {
		this.show_date = show_date;
	}

	public String getShow_time() {
		return show_time;
	}

	public void setShow_time(String show_time) {
		this.show_time = show_time;
	}

	public String getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(String auditorium) {
		this.auditorium = auditorium;
	}

	public Long getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(Long ticket_price) {
		this.ticket_price = ticket_price;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", title=" + title + ", show_date=" + show_date + ", show_time=" + show_time
				+ ", auditorium=" + auditorium + ", ticket_price=" + ticket_price + "]";
	}
	
	
		
}
	
	

		