package com.patil.movie_service.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patil.movie_service.entity.Movie;
import com.patil.movie_service.service.MovieService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllMovies(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
		if (id!=null && name!=null) {			
			return ResponseEntity.badRequest().body("please provide name or id in URL, only one.");
		} else if (id!=null) { 
			return ResponseEntity.status(HttpStatus.OK).body(movieService.retrieveMovieById(id)) ;
		} else if (name!=null){
			return ResponseEntity.status(HttpStatus.OK).body(movieService.retrieveMovieByName(name));
		}
		return ResponseEntity.status(HttpStatus.OK).body(movieService.retrieveAllMovies());
	}
	
	
	
	@PostMapping()
	public ResponseEntity<String> setMovie(@Valid @RequestBody Movie movie) {
		movieService.createMovie(movie);
		URI location = URI.create("/"+movie.getId());
		return ResponseEntity.created(location).body("movie created successfully.");
		
	}
	

}
