package com.patil.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patil.movie_service.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
