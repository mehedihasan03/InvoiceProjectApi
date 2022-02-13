package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.MailModel;

@Service
public class MailServiceImplement implements MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendUserEmail(MailModel mailModel) throws MailSendException {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("mehedi.hasan.jee@gmail.com");
		msg.setTo(mailModel.getReceiver());
		msg.setSubject("Welcome Sir");
		msg.setText("You are successfully registered as a new invoice user");
		javaMailSender.send(msg);
		System.out.println("====ok=====");
		
	}

	@Override
	public void sendCustomerEmail(MailModel mailModel) throws MailSendException {
		SimpleMailMessage msg  = new SimpleMailMessage();
		msg.setFrom("mehedi.hasan.jee@gmail.com");
		msg.setTo(mailModel.getReceiver());
		msg.setSubject("Welcome Sir");
		msg.setText("You are successfully registered as a new Customer");
		javaMailSender.send(msg);
		System.out.println("====ok=====");
	}

}
