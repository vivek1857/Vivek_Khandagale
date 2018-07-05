package com.sky.parentalcontrol.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.movie.service.MovieService;
import com.sky.movie.service.exception.TechnicalFailureException;
import com.sky.movie.service.exception.TitleNotFoundException;
import com.sky.parentalcontrol.ParentalControlLevel;
@Service
public class ParentalControlServiceImpl implements ParentalControlService {

	@Autowired
	private MovieService movieService;
	private static final Logger lOG = LoggerFactory.getLogger(ParentalControlServiceImpl.class);

	
	public ParentalControlServiceImpl() {
	}

	@Override
	public boolean canViewMovieForGivenParentalControl(String userParentControlLevel, String movieId) throws TitleNotFoundException, TechnicalFailureException {
		lOG.debug("In  ParentalControlServiceImpl:isMovieViableForAGivenParentalControl { movieId: {}, parentControlLevel: {} }.", movieId, userParentControlLevel);
		String movieParentalControlLevel = movieService.getParentalControlLevel(movieId);
		return canView(movieParentalControlLevel,userParentControlLevel);
	}
	private boolean canView(String moviesParentalControlLevel,String userParentControlLevel) {
		
		int minAgeForMovie = ParentalControlLevel.findParentalControlLevel(moviesParentalControlLevel).getMinAge();
		int ageForUserPL = ParentalControlLevel.findParentalControlLevel(userParentControlLevel).getMinAge();
		return minAgeForMovie <= ageForUserPL;
			
		
	}

}
