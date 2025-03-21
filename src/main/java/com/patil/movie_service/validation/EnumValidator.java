package com.patil.movie_service.validation;

import java.util.Arrays;

import com.patil.movie_service.enumeration.MovieGenre;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, String>{
	
	private MovieGenre[] validValue;
	
	@Override
	public void initialize(ValidEnum constraintAnnotation) {
		validValue = (MovieGenre[]) constraintAnnotation.enumClass().getEnumConstants();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Arrays.stream(validValue)
				.anyMatch(enumValue -> enumValue.name().equals(value));
	}

}
