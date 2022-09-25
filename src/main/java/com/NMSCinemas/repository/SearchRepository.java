package com.NMSCinemas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NMSCinemas.model.*;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {
	@Query(value = "SELECT * FROM movies WHERE title = :title", nativeQuery = true)
	public Optional<Search> searchMovie(@Param("title") String searchMovie);
}
