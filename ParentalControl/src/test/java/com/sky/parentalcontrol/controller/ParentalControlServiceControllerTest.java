package com.sky.parentalcontrol.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParentalControlServiceControllerTest {
	
	@Autowired
	ParentalControlServiceController parentalControlServiceController;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAllowedToWatchMovie() {
		boolean canWatch = parentalControlServiceController.allowedToWatchMovie("18", "123");
		Assert.assertTrue("As provided parental level is highest so any movie could be seen ",canWatch==true);
	}

}
