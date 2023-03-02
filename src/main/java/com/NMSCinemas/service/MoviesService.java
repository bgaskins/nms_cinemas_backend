package com.NMSCinemas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NMSCinemas.model.Movies;
import com.NMSCinemas.repository.MovieRepository;

// Create, Read, Update, Delete
// Get movies by id and title.


@Service
public class MoviesService {

	@Autowired
	private MovieRepository movieRepository;
	
	// Creates a new movie
	public Movies createMovie(Movies movie) {
		return movieRepository.save(movie);
	}
	// Returns all movies in the database
	public List<Movies> getAllMovies(){
		return movieRepository.findAll();
	}
	// Returns a specific movie with the given ID
	public Movies getMovieById(Long id) {
		if(movieRepository.findById(id).isPresent()) {
			return movieRepository.findById(id).get();
		}
		else {
			return null;
		}
	}
	// Returns an optional movie with the given title
	public Optional<Movies> searchMovie(String title) {
	    return movieRepository.searchMovie(title);
			}
	// Updates an existing movie with the given ID and data
	public Movies updateMovie(Long id, Movies newMovie) {
		if(movieRepository.findById(id).isPresent()) {
			Movies oldMovie= movieRepository.findById(id).get();
			oldMovie.setTitle(newMovie.getTitle());
			oldMovie.setTicket_price(newMovie.getTicket_price());
			oldMovie.setLanguage(newMovie.getLanguage());
			oldMovie.setDescription(newMovie.getDescription());
			oldMovie.setShowtime(newMovie.getShowtime());
			oldMovie.setAuditorium(newMovie.getAuditorium());
			
			return movieRepository.save(oldMovie);
		}
		else {
			return null;
		}
	}
	
	// Deletes a movie with the given ID
	public boolean deleteMovie(Long id) {
		if(movieRepository.findById(id).isPresent()) {
			movieRepository.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	}
