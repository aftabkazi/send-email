package com.sendEmail.sendEmail.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


import com.sendEmail.sendEmail.entity.EmailDetails;

@Service
public class EmailService {
	
	@Autowired 
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") private String sender;

	public String sendMail(EmailDetails details) {
		try {
			 SimpleMailMessage mailMessage= new SimpleMailMessage();
			 
			 mailMessage.setFrom(sender);
			 mailMessage.setTo(details.getRecipent());
			 mailMessage.setText(details.getMsgBody());
			 mailMessage.setSubject(details.getSubject());
			 
			 javaMailSender.send(mailMessage);
			 return "Mail send Sucessfully";
		}
		catch(Exception e) {
			return "Error while sending mail";
		}
	}
//	public String sendEmailWithAttachment(EmailDetails details){
//		
//		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper;
//		try {
//			mimeMessageHelper= new MimeMessageHelper(mimeMessage, true);
//			
//			mimeMessageHelper.setFrom(sender);
//			mimeMessageHelper.setTo(details.getRecipent());
//			mimeMessageHelper.setText(details.getMsgBody());
//			mimeMessageHelper.setTo(details.getSubject());
//			
//			 FileSystemResource file=new FileSystemResource(new File(details.getAttachement()));
//			
//			mimeMessageHelper.addAttachment(file.getFilename(),file);
//			
//			javaMailSender.send(mimeMessage);
//			return "mail send Sucessfully";
//		}
//		catch(Exception e) {
//			return "error in sending mail";
//		}
//	}
	 public String
	    sendMailWithAttachment(EmailDetails details)
	    {
	        // Creating a mime message
	        MimeMessage mimeMessage
	            = javaMailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper;
	 
	        try {
	 
	            // Setting multipart as true for attachments to
	            // be send
	            mimeMessageHelper
	                = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setFrom(sender);
	            mimeMessageHelper.setTo(details.getRecipent());
	            mimeMessageHelper.setText(details.getMsgBody());
	            mimeMessageHelper.setSubject(
	                details.getSubject());
	 
	            // Adding the attachment
	            FileSystemResource file
	                = new FileSystemResource(
	                    new File(details.getAttachement()));
	 
	            mimeMessageHelper.addAttachment(
	                file.getFilename(), file);
	 
	            // Sending the mail
	            javaMailSender.send(mimeMessage);
	            return "Mail sent Successfully";
	        }
	 
	        // Catch block to handle MessagingException
	        catch (Exception e) {
	 
	            // Display message when exception occurred
	            return "Error while sending mail!!!";
	        }
	    }
}
