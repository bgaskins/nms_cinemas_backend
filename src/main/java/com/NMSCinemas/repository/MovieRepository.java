package com.NMSCinemas.repository;

import java.sql.Blob;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NMSCinemas.model.*;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {
	@Query(value = "SELECT * FROM id WHERE id = :id", nativeQuery = true)
	public Optional<Movies> getMovieById(@Param("id") Long id);
	
	@Query(value = "INSERT INTO movies (title, ticket_price, language, description, showtime, auditorium, image) VALUES (?,?,?,?,?,?,?)", nativeQuery = true)
	public Optional<Movies> createMovie(@Param("id") Long id,
			@Param("title") String title,
			@Param("ticket_price") String ticket_price,
			@Param("language") String language,
			@Param("description") String description,
			@Param("showtime") String showtime,
			@Param("auditorium") String auditorium,
			@Param("image") Blob image);
	
	@Query(value = "UPDATE admin SET title=?, ticket_price=?, language=?, description=?, showtime=?, auditorium=?, image=? WHERE id=?", nativeQuery = true)
	public Optional<Movies> updateMovie(@Param("id") Long id);
	
	@Query(value = "DELETE * FROM movies WHERE id = :id", nativeQuery = true)
	public Optional<Movies> deleteMovie(@Param("id") Long id);
}
