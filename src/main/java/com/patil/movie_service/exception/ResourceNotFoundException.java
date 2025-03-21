package com.patil.movie_service.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2342746110254565260L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
