package com.sendEmail.sendEmail.entity;

import javax.persistence.Entity;


@Entity
public class EmailDetails {
	
	private String recipent;
	private String msgBody;
	private String subject;
	private String attachement;
	
	public EmailDetails() {
		super();
	}

	public EmailDetails(String recipent, String msgBody, String subject, String attachement) {
		super();
		this.recipent = recipent;
		this.msgBody = msgBody;
		this.subject = subject;
		this.attachement = attachement;
	}

	public String getRecipent() {
		return recipent;
	}

	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachement() {
		return attachement;
	}

	public void setAttachement(String attachement) {
		this.attachement = attachement;
	}
}
