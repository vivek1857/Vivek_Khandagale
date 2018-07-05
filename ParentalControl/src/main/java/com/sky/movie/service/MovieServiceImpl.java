package com.sky.movie.service;

import org.springframework.stereotype.Component;

import com.sky.movie.service.exception.TechnicalFailureException;
import com.sky.movie.service.exception.TitleNotFoundException;
import com.sky.parentalcontrol.ParentalControlLevel;

/**
 * The Class MovieServiceImpl.
 *
 * @author Vivek Khandagale
 */
@Component
public class MovieServiceImpl implements MovieService {

	/* (non-Javadoc)
	 * @see com.sky.movie.service.MovieService#getParentalControlLevel(java.lang.String)
	 */
	@Override
	public String getParentalControlLevel(String movieId)
			throws TitleNotFoundException, TechnicalFailureException {
		ParentalControlLevel[] values = ParentalControlLevel.values();
		int random = (int)(Math.random() *10);
		String rating = ParentalControlLevel.EIGHTEEN.getRating();
		try {
		  rating = values[random].getRating();
		}catch(ArrayIndexOutOfBoundsException ex){
			//
		}
		return rating;
	}

	

}
