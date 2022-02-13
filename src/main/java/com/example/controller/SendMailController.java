package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MailModel;
import com.example.service.MailService;

@RestController
@CrossOrigin(origins = "*")
public class SendMailController {
	
	@Autowired
	private  MailService mailService;

	@PostMapping("/sendUserEmail")
	public ResponseEntity<?> sendUserEmail(@RequestBody MailModel mailModel){
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			mailService.sendUserEmail(mailModel);
			data.put("status", "Success");
			data.put("message", "mail send successfully");
			return ResponseEntity.status(HttpStatus.OK).body(data);
		} catch (Exception e) {
			data.put("status", "Failed");
			data.put("message", e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
		}
	}
	
	@PostMapping("/sendCustomerEmail")
	public ResponseEntity<?> sendCustomerEmail(@RequestBody MailModel mailModel){
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			mailService.sendCustomerEmail(mailModel);
			data.put("status", "Success");
			data.put("message", "mail send successfully");
			return ResponseEntity.status(HttpStatus.OK).body(data);
		} catch (Exception e) {
			data.put("status", "Failed");
			data.put("message", e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
		}
	}
}
