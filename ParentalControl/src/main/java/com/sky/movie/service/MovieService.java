package com.sky.movie.service;

import com.sky.movie.service.exception.TechnicalFailureException;
import com.sky.movie.service.exception.TitleNotFoundException;

public interface MovieService {

	public String getParentalControlLevel(String movieId) throws TitleNotFoundException,TechnicalFailureException;
}
