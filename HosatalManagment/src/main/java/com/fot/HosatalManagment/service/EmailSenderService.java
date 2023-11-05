package com.fot.HosatalManagment.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;



    public void sendHtmlEmail(String toEmail, String subject, String htmlBody) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("vimudhi.arcenciel@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(htmlBody, true); // Set the second parameter to true for HTML content
            mailSender.send(message);
            System.out.println("HTML Email Sent...");
        } catch (Exception e) {
            // Handle exceptions
            System.err.println("Error sending HTML email: " + e.getMessage());
        }
    }


}

