package com.ordermgmt.notification.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermgmt.notification.domain.NotificationType;
import com.ordermgmt.notification.domain.User;


@Service
public class NotificationServiceImpl implements NotificationService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmailService emailService;

	@Override
	public void sendRegistrationEmail(User user) {
		
		log.info("entered into sendNotification method");

		final NotificationType type = NotificationType.WELCOME;

		try {
			emailService.send(type, user, null);
		} catch (Throwable t) {
			log.error("an error during sending notification for {}", user, t);
		}
		
	}

	


}
