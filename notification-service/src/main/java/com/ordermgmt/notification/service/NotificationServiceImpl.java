package com.ordermgmt.notification.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ordermgmt.notification.client.AccountServiceClient;
import com.ordermgmt.notification.domain.NotificationType;
import com.ordermgmt.notification.domain.Recipient;
import com.ordermgmt.notification.domain.User;

@Service
public class NotificationServiceImpl implements NotificationService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private AccountServiceClient client;

	@Autowired
	private RecipientService recipientService;

	@Autowired
	private EmailService emailService;

	@Override
	@Scheduled(cron = "${backup.cron}")
	public void sendBackupNotifications() {

//		final NotificationType type = NotificationType.BACKUP;
//
//		List<Recipient> recipients = recipientService.findReadyToNotify(type);
//		log.info("found {} recipients for backup notification", recipients.size());
//
//		recipients.forEach(recipient -> CompletableFuture.runAsync(() -> {
//			try {
//				String attachment = client.getAccount(recipient.getAccountName());
//				emailService.send(type, recipient, attachment);
//				recipientService.markNotified(type, recipient);
//			} catch (Throwable t) {
//				log.error("an error during backup notification for {}", recipient, t);
//			}
//		}));
	}

	@Override
	@Scheduled(cron = "${remind.cron}")
	public void sendRemindNotifications() {

//		final NotificationType type = NotificationType.REMIND;
//
//		List<Recipient> recipients = recipientService.findReadyToNotify(type);
//		log.info("found {} recipients for remind notification", recipients.size());
//
//		recipients.forEach(recipient -> CompletableFuture.runAsync(() -> {
//			try {
//				emailService.send(type, recipient, null);
//				recipientService.markNotified(type, recipient);
//			} catch (Throwable t) {
//				log.error("an error during remind notification for {}", recipient, t);
//			}
//		}));
	}
	
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
