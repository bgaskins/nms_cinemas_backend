package com.NMSCinemas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NMSCinemas.model.Movies;
import com.NMSCinemas.repository.MovieRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/movies")
		
public class MoviesController {
		
	 @Autowired
	  MovieRepository movieRepository;


	  @GetMapping("/find/{id}")
	  public ResponseEntity<Movies> getMoviesById(@PathVariable("id") long id) {
	    Optional<Movies> moviesData = movieRepository.findById(id);

	    if (moviesData.isPresent()) {
	      return new ResponseEntity<>(moviesData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/create")
	  public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
	    try {
	     Movies _movies = movieRepository
	          .save(new Movies (movie.getTitle(), movie.getTicket_price(), movie.getLanguage(), movie.getDescription(), movie.getTicket_price(), movie.getAuditorium(), movie.getImage()));
	      return new ResponseEntity<>(_movies, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/update/{id}")
	  public ResponseEntity<Movies> updateMovie(@PathVariable("id") long id, @RequestBody Movies movie) {
	    Optional<Movies> moviesData = movieRepository.findById(id);

	    if (moviesData.isPresent()) {
	      Movies _movies = moviesData.get();
	      _movies.setTitle(movie.getTitle());
	      _movies.setTicket_price(movie.getTicket_price());
	      _movies.setLanguage(movie.getLanguage());
	      _movies.setDescription(movie.getDescription());
	      _movies.setShowtime(movie.getShowtime());
	      _movies.setAuditorium(movie.getAuditorium());
	      _movies.setImage(movie.getImage());
	      return new ResponseEntity<>(movieRepository.save(_movies), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
	    try {
	      movieRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}