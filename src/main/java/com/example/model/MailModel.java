package com.example.model;


public class MailModel {

	private long id;
	private String receiver;
	private String sub;
	private String message;
	
	public MailModel() {		
	}
	public MailModel(long id, String receiver, String sub, String message) {
		
		this.id = id;
		this.receiver = receiver;
		this.sub = sub;
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
