package com.sky.parentalcontrol.service;

import com.sky.movie.service.exception.TechnicalFailureException;
import com.sky.movie.service.exception.TitleNotFoundException;

/**
 * The Interface ParentalControlService.
 *
 * @author Vivek Khandagale
 */
public interface ParentalControlService {

	/**
	 * Can view movie for given parental control.
	 *
	 * @param parentalControlLevel the parental control level
	 * @param movieId the movie id
	 * @return true, if successful
	 * @throws TitleNotFoundException the title not found exception
	 * @throws TechnicalFailureException the technical failure exception
	 */
	public boolean canViewMovieForGivenParentalControl(String parentalControlLevel,String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
