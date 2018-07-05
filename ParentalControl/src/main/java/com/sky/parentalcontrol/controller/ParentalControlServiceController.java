package com.sky.parentalcontrol.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.parentalcontrol.ParentalControlLevel;
import com.sky.parentalcontrol.exception.InvalidvalidateParenatalContolLevelException;
import com.sky.parentalcontrol.service.ParentalControlService;

/**
 * The Class ParentalControlServiceController.
 */
@RestController
@RequestMapping("/api/v1/sky")
public class ParentalControlServiceController {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(ParentalControlServiceController.class);
	
	/** The parental control service. */
	@Autowired
    private  ParentalControlService parentalControlService;

    /**
     * Allowed to watch movie.
     *
     * @param currentParenatalContolLevel the current parenatal contol level
     * @param movieId the movie id
     * @return the boolean
     */
    @GetMapping("/parentalcontrol/{pcl}/allowedtowatch/movie/{movieId}")
    public Boolean allowedToWatchMovie(@PathVariable(value = "pcl") String currentParenatalContolLevel,
    		@PathVariable(value = "movieId") String movieId){
       log.debug("calling parentalControlService");
       if(validateParenatalContolLevel(currentParenatalContolLevel))
    	   throw new InvalidvalidateParenatalContolLevelException("Invalid parental control level");
       return parentalControlService.canViewMovieForGivenParentalControl(currentParenatalContolLevel, movieId);
    }
    private boolean validateParenatalContolLevel(String currentParenatalContolLevel) {
    	return ParentalControlLevel.findParentalControlLevel(currentParenatalContolLevel) == null;
    	
    }
}
