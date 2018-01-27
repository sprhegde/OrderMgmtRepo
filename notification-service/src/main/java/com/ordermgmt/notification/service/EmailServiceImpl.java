package com.ordermgmt.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ordermgmt.notification.domain.NotificationType;
import com.ordermgmt.notification.domain.User;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.MessageFormat;

@Service
@RefreshScope
public class EmailServiceImpl implements EmailService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	@Override
	public void send(NotificationType type, User user, String attachment) throws MessagingException, IOException {

		final String subject = env.getProperty(type.getSubject());
		final String text = MessageFormat.format(env.getProperty(type.getText()), user.getUsername());

		MimeMessage message = mailSender.createMimeMessage();

//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		helper.setFrom("OrderMgmt@test.com");
//		helper.setTo(user.getEmail());
//		helper.setSubject(subject);
//		helper.setText(text);
//
//		if (StringUtils.hasLength(attachment)) {
//			helper.addAttachment(env.getProperty(type.getAttachment()), new ByteArrayResource(attachment.getBytes()));
//		}
//
//		mailSender.send(message);
		
		SendGrid sendgrid = new SendGrid(env.getProperty("sendgrid.apikey.value"));
		SendGrid.Email welcomeMail = new SendGrid.Email();
		welcomeMail.addTo(user.getEmail());
		welcomeMail.addToName("Shiva");
		welcomeMail.setFrom("OrderMgmt@test.com");
		welcomeMail.setSubject(subject);
		welcomeMail.setText(text);

		try {
		    SendGrid.Response response = sendgrid.send(welcomeMail);
		    System.out.println(response.getCode()); 
		    System.out.println(response.getMessage());
		} catch (SendGridException sge) {
			System.out.println("ERROR IS"+sge.getMessage());
		}

		log.info("{} email notification has been send to {}", type, user.getEmail());
	}
	
	
	
}
