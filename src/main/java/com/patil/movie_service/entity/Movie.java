package com.patil.movie_service.entity;

import com.patil.movie_service.enumeration.MovieGenre;
import com.patil.movie_service.validation.ValidEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "name cannot be empty")
	private @NonNull String name;
	
	@NotBlank (message = "description cannot be empty")
	private @NonNull String description;
	
	@ValidEnum (enumClass = MovieGenre.class, message = "Invalid genre, Allowed values: ACTION, SCI_FI, HORROR, etc.")
	@NotBlank (message = "genre cannot be empty")
	private @NonNull String genre;
	
	@Min(value = 0, message = "must be between 0 to 10")
	@Max(value = 10, message = "must be between 0 to 10")
	private @NonNull Float rating;
}
