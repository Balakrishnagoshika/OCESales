package com.ocesales.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	
	public static void main(String[] args) throws EmailException
	{
		
	System.out.println("=======Email Started=================");
	
	Email email = new SimpleEmail();
	
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("bgoshika@gmail.com", "Bhavyesh@123"));
	email.setSSLOnConnect(true);
	email.setFrom("balakrishnagosika@gmail.com");
	email.setSubject("TestEmail");
	email.setMsg("this is the test email check");
	email.addTo("balakrishnagosika@gmail.com");
	email.send();
	
	System.out.println("=======Email Sent============");
		
	}

}
