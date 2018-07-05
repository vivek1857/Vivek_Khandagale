package com.sky.movie.service.exception;

public class TechnicalFailureException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public TechnicalFailureException(String message) {
		super(message);
	}
}
