package com.ordermgmt.notification.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImplTest {
	
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@InjectMocks
	private EmailServiceImpl emailService;

	@Mock
	private JavaMailSender mailSender;

	@Mock
	private Environment env;

	@Captor
	private ArgumentCaptor<MimeMessage> captor;

	@Before
	public void setup() {
		initMocks(this);
		when(mailSender.createMimeMessage())
				.thenReturn(new MimeMessage(Session.getDefaultInstance(new Properties())));
	}


}