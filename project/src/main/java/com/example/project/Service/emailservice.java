package com.example.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.project.Entity.emailentity;
import com.example.project.repo.emailrepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailservice {
	@Autowired JavaMailSender sender;
	@Autowired emailrepo repo;
	public String sendmail(String receiver,String subject,String body) {
		try {
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setTo(receiver);
		helper.setSubject(subject);
		helper.setText(body);
		sender.send(message);
		
		emailentity email=new emailentity();
		email.setReceiver(receiver);
		email.setSubject(subject);
		email.setBody(body);
		repo.save(email);
		return "Email sent successfully"+receiver;
		} 
		catch (MessagingException e) {
			return "Mail not found"+e.getMessage();
		}
	}
	
	
}
