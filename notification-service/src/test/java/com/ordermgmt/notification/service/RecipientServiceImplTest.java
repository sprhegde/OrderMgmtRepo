package com.ordermgmt.notification.service;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;


public class RecipientServiceImplTest {

	

	@Before
	public void setup() {
		initMocks(this);
	}

	

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailToFindRecipientWhenAccountNameIsEmpty() {
	//	recipientService.findByAccountName("");
	}

	

	

	
}