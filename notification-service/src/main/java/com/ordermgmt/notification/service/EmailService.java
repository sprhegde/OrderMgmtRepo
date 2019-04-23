package com.ordermgmt.notification.service;

import com.ordermgmt.notification.domain.NotificationType;
import com.ordermgmt.notification.domain.User;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, User user	, String attachment) throws MessagingException, IOException;

}
