package com.NMSCinemas.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movies")
public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "ticket_price")
	private String ticket_price;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "showtime")
	private String showtime;
	
	@Column(name = "auditorium")
	private String auditorium;
	
	@Column(name = "image")
	private Blob image;
	
	public Movies() {
		
	}
	
	public Movies(String title, String ticket_price, String language, String description, String showtime, String auditorium,
			Blob image) {
		super();
		this.title = title;
		this.ticket_price = ticket_price;
		this.language = language;
		this.description = description;
		this.showtime = showtime;
		this.auditorium = auditorium;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(String ticket_price) {
		this.ticket_price = ticket_price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public String getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(String auditorium) {
		this.auditorium = auditorium;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", ticket_price=" + ticket_price + ", language=" + language
				+ ", description=" + description + ", showtime=" + showtime + ", auditorium=" + showtime + ", image=" + image + "]";
	}

}
	
