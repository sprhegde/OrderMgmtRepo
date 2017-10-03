package com.ordermgmt.notification.service;

import javax.mail.MessagingException;

import com.ordermgmt.notification.domain.NotificationType;
import com.ordermgmt.notification.domain.User;

import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, User user, String attachment) throws MessagingException, IOException;

}
