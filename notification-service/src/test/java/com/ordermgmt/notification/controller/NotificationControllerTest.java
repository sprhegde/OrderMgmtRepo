package com.ordermgmt.notification.controller;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordermgmt.notification.NotificationServiceApplication;
import com.ordermgmt.notification.domain.NotificationSettings;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NotificationServiceApplication.class)
@WebAppConfiguration
public class NotificationControllerTest {

	private static final ObjectMapper mapper = new ObjectMapper();

	@InjectMocks
	private NotificationController recipientController;

	@Mock
	//private RecipientService recipientService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(recipientController).build();
	}

	
}