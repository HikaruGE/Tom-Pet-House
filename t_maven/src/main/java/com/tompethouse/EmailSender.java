package com.tompethouse;

import java.util.ArrayList;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailSender extends Thread {

	private JavaMailSender emailSender;
	private static ArrayList<String> emails;

	public EmailSender(ArrayList<String> emails) {
		this.emails = emails;
		start();
	}

	public void run() {
		emailSender = getJavaMailSender();
		for (String s : emails) {
			sendEmail(s,
				"Tom's Pet House - Automatic Appointment Reminder",
				"This email is a reminder that your doggy has an appointment "
				+ "with Tom's Pet House in 24 hours! :)");
			System.out.println("Email sent to " + s);
		}
	}

	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("tom97376pet@gmail.com");
		mailSender.setPassword("123qweRTY");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
}
