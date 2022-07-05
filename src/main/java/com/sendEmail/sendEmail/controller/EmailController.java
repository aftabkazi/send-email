package com.sendEmail.sendEmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sendEmail.sendEmail.entity.EmailDetails;
import com.sendEmail.sendEmail.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/hi")
	public String HelloWorld() {
		return "Hello Aftab";
	}
	@PostMapping("/sendemail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status=emailService.sendMail(details);
		return status;
	}
	
	@PostMapping("/sendemailwithattachments")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status=emailService.sendMailWithAttachment(details);
		return status;
	}
}
