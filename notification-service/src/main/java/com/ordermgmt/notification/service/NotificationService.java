package com.ordermgmt.notification.service;


import com.ordermgmt.notification.domain.User;

public interface NotificationService {

	void sendBackupNotifications();

	void sendRemindNotifications();
	
	void sendRegistrationEmail(User user);
}
