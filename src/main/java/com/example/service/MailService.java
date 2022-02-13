package com.example.service;

import com.example.model.MailModel;

public interface MailService {

	public void sendUserEmail(MailModel mailModel);
	
	public void sendCustomerEmail(MailModel mailModel);
}
