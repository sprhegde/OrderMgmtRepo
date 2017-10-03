package com.ordermgmt.customer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ordermgmt.customer.domain.User;

@FeignClient(name = "notification-service")
public interface NotificationServiceClient {

	@RequestMapping(method = RequestMethod.PUT, value = "/notifications/notification/registration")
	void sendMail(User user);

}
