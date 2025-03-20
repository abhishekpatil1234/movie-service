package com.patil.movie_service.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patil.movie_service.entity.Movie;

@Controller
public class MovieController {
	
	@GetMapping()
	public List<Movie> getAllMovies() {
		return null;
	}
	
	@PostMapping()
	public String setMovie() {
		return null;
		
	}
	
	@GetMapping("/")
	public Movie getMovieById(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
		return null;
		
	}
	

}
