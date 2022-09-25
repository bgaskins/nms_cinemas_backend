package com.NMSCinemas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search")
public class Search {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title")
	private String title;
	
	public Search() { }

	public Search(String title) {
		super();
		this.title = title;
	}

	public String getMovieName() {
		return title;
	}

	public void setMovieName(String title) {
		this.title = title;
	}
}
