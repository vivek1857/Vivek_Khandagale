package com.sky.parentalcontrol.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import com.sky.movie.service.MovieService;
import com.sky.movie.service.exception.TechnicalFailureException;
import com.sky.movie.service.exception.TitleNotFoundException;
import com.sky.parentalcontrol.exception.InvalidvalidateParenatalContolLevelException;

public class ParentalControlServiceImplTest {

	@Mock
	private MovieService movieService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@InjectMocks
	private ParentalControlService parentalControlService = new ParentalControlServiceImpl();
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCanViewMovieForGivenParentalControlWhenMoviewParentalControlLevelIsU() {
		Mockito.when(movieService.getParentalControlLevel(Mockito.anyString())).thenReturn("U");
		boolean canWatch = parentalControlService.canViewMovieForGivenParentalControl("18", "123");
		Assert.isTrue(canWatch,"Expected to watch movie should be true");
	}
	@Test
	public void testCanViewMovieForGivenParentalControlWhenMoviewParentalControlLevelIs18AndUserPCLisU() {
		Mockito.when(movieService.getParentalControlLevel(Mockito.anyString())).thenReturn("18");
		boolean canWatch = parentalControlService.canViewMovieForGivenParentalControl("U", "123");
		Assert.isTrue(canWatch==false,"Expected to watch movie should be  false");
	}
	
	@Test
	public void testTechnicalFailureExceptionForCanViewMovieForGivenParentalControl() {
		Mockito.when(movieService.getParentalControlLevel(Mockito.anyString())).thenThrow(TechnicalFailureException.class);
		exception.expect(TechnicalFailureException.class);
		boolean canWatch = parentalControlService.canViewMovieForGivenParentalControl("18", "123");
	}
	
	@Test
	public void testTitleNotFoundExceptionForCanViewMovieForGivenParentalControl() {
		Mockito.when(movieService.getParentalControlLevel(Mockito.anyString())).thenThrow(TitleNotFoundException.class);
		exception.expect(TitleNotFoundException.class);
		boolean canWatch = parentalControlService.canViewMovieForGivenParentalControl("18", "123");
	}
	
	@Test
	public void testInvalidvalidateParenatalContolLevelExceptionForCanViewMovieForGivenParentalControl() {
		Mockito.when(movieService.getParentalControlLevel(Mockito.anyString())).thenThrow(InvalidvalidateParenatalContolLevelException.class);
		exception.expect(InvalidvalidateParenatalContolLevelException.class);
		boolean canWatch = parentalControlService.canViewMovieForGivenParentalControl("ABC", "123");
	}

}
