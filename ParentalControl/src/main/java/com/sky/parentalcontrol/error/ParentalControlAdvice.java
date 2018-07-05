package com.sky.parentalcontrol.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sky.movie.service.exception.TechnicalFailureException;
import com.sky.movie.service.exception.TitleNotFoundException;
import com.sky.parentalcontrol.exception.InvalidvalidateParenatalContolLevelException;

/**
 * The Class ParentalControlAdvice.
 */
@ControllerAdvice
@ResponseBody
public class ParentalControlAdvice {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(ParentalControlAdvice.class);
	
	/**
	 * Instantiates a new parental control advice.
	 */
	public ParentalControlAdvice() {
	}
	
	/**
	 * Handle technical failure exception.
	 *
	 * @param ex the ex
	 * @return the parental control error
	 */
	@ExceptionHandler(TechnicalFailureException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ParentalControlError handleTechnicalFailureException(TechnicalFailureException ex){
		log.error("Technical Failure while finding parental Control",ex.getMessage());
		return new ParentalControlError("Technical Failure while finding parental Control", ex.getMessage());
		
	}
	
	/**
	 * Handle title not found exception.
	 *
	 * @param ex the ex
	 * @return the parental control error
	 */
	@ExceptionHandler(TitleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ParentalControlError handleTitleNotFoundException(TitleNotFoundException ex){
		log.info("Can not find the title for movie ",ex.getMessage());
		return new ParentalControlError("Can not find the title for movie ", ex.getMessage());
		
	}
	@ExceptionHandler(InvalidvalidateParenatalContolLevelException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ParentalControlError handleInvalidvalidateParenatalContolLevelException(InvalidvalidateParenatalContolLevelException ex){
		log.info("Invalid parental controle level ",ex.getMessage());
		return new ParentalControlError("Invalid parental controle level ", ex.getMessage());
		
	}
	
}
