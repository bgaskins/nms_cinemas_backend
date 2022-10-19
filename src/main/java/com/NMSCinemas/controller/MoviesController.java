package com.NMSCinemas.controller;

import java.util.List;

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
import com.NMSCinemas.service.MoviesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/movies")
public class MoviesController {
		
	 @Autowired
	  MoviesService moviesService;


	 @GetMapping("/all")
		public List<Movies> getAllMovies(){
			return moviesService.getAllMovies();
			
		}
	 
	 @PostMapping("/create")
	  public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
	    try {
	     Movies _movies = moviesService
	          .createMovie(new Movies (movie.getTitle(), movie.getTicket_price(), movie.getLanguage(), movie.getDescription(), movie.getTicket_price(), movie.getAuditorium()));
	      return new ResponseEntity<>(_movies, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 }
	  
	 
	  @GetMapping("/find/{id}")
	  public ResponseEntity<Movies> getMoviesById(@PathVariable Long id) {
	    Movies moviesData = moviesService.getMovieById(id);

	    if (moviesData != null) {
	      return new ResponseEntity<Movies>(moviesData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<Movies>(moviesData, HttpStatus.NOT_FOUND);
	    }
	  }
	  

	

	  @PutMapping("/update/{id}")
	  public ResponseEntity<Object> updateMovie(@PathVariable("id") Long id, @RequestBody Movies newMovie) {
		    Movies moviesData = moviesService.updateMovie(id, newMovie);			
			if (moviesData != null) {
				return new ResponseEntity<Object>(moviesData,HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("No Movie Available to Update",HttpStatus.NOT_FOUND);
	  }
	  }


	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
		  boolean result = moviesService.deleteMovie(id);
			if(result) {
				return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
			}else { 
				return new ResponseEntity<String>("NO user Found", HttpStatus.NOT_FOUND);
			}
	  }
}