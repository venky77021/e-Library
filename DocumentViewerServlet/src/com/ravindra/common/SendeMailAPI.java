package com.ravindra.common;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendeMailAPI {
	public void sendEmail(String registeredUser, String registeredEmail) {
		Properties p = LoadProperties.getProperties();
		Properties props = new Properties();
		props.put(p.getProperty("mailSMTP"), p.getProperty("mailSMTPFlag"));
		props.put(p.getProperty("mailStarttls"), p.getProperty("mailStarttlsFlag"));
		props.put(p.getProperty("mailHost"), p.getProperty("mailHostGmail"));
		props.put(p.getProperty("mailHostPort"), p.getProperty("mailHostPortNumber"));

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(p.getProperty("emailUser"), p.getProperty("emailPassword"));
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(p.getProperty("emailUser")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(registeredEmail));
			message.setSubject("Welcome To e-Library");
			message.setText("Thanks for Registering the e-Library" + "your user id " + registeredUser);

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
