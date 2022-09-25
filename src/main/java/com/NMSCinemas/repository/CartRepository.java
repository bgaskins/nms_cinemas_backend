package com.NMSCinemas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NMSCinemas.model.*;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	@Query(value = "SELECT * FROM cart WHERE id = :id", nativeQuery = true)
	public Optional<Cart> findTicket(@Param("id") Long id);
	
	
	@Query(value = "INSERT INTO cart (title, show_date, show_time, auditorium, ticket_price) VALUES (?,?,?,?,?)", nativeQuery = true)
	public Optional<Cart> addToCart(@Param("id") Long id,
			@Param("title") String title,
			@Param("show_date") String show_date,
			@Param("show_time") String show_time,
			@Param("auditorium") String auditorium,
			@Param("ticket_price") String ticket_price);
	
	@Query(value = "DELETE * FROM cart WHERE id = :id", nativeQuery = true)
	public Optional<Cart> deleteFromCart(@Param("id") Long id);
	
	@Query(value = "DELETE * FROM cart", nativeQuery = true)
	public Optional<Cart> deleteCart(@Param("id") Long id);

}
