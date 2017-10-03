package com.ordermgmt.notification.controller;

import com.ordermgmt.notification.domain.User;
import com.ordermgmt.notification.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@RequestMapping(path = "/registration", method = RequestMethod.PUT)
	public void sendMail(@Valid @RequestBody User user) {
		notificationService.sendRegistrationEmail(user);
	}
}
