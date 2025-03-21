package com.patil.movie_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patil.movie_service.entity.Movie;
import com.patil.movie_service.exception.ResourceNotFoundException;
import com.patil.movie_service.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> retrieveAllMovies() {
		return movieRepository.findAll();
	}
	
	public Movie retrieveMovieById(Long id) {
		return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("movie not found. id:"+id));
	}
	
	public Movie retrieveMovieByName(String name) {
		return movieRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("movie not found. name:"+name));
	}

	public void createMovie(Movie movie) {
		movieRepository.save(movie);
	}

}
