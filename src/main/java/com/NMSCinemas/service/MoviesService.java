package com.NMSCinemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NMSCinemas.model.Movies;
import com.NMSCinemas.repository.MovieRepository;


@Service
public class MoviesService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Movies createMovie(Movies movie) {
		return movieRepository.save(movie);
	}
	public List<Movies> getAllMovies(){
		return movieRepository.findAll();
	}
	public Movies getMovieById(Long id) {
		if(movieRepository.findById(id).isPresent()) {
			return movieRepository.findById(id).get();
		}
		else {
			return null;
		}
	}
	
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
