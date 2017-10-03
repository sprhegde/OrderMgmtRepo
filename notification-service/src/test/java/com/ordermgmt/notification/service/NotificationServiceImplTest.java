package com.ordermgmt.notification.service;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class NotificationServiceImplTest {

	@InjectMocks
	private NotificationServiceImpl notificationService;


	@Mock
	private EmailService emailService;

	@Before
	public void setup() {
		initMocks(this);
	}

	
}