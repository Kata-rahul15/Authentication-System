package com.Application.AuthService.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailTemplateService emailTemplateService;

    @Value("${spring.mail.properties.mail.smtp.from}")
    private String fromEmail;

    public void sendWelcomeEmail(String name,String toEmail){
        String html = emailTemplateService.buildWelcomeEmail(toEmail,name);
        htmlMailSender(toEmail,"Welcome to TalentPrep",html);
    }
    public void sendVerifyOtp(String toEmail,String name,String otp){
        String html=emailTemplateService.buildVerifyOtpEmail(toEmail,name,otp);
        htmlMailSender(toEmail,"Verify Your TalentPrep Account",html);

    }
    public void sendResetOtp(String toEmail,String name,String otp){
        String html=emailTemplateService.buildResetOtpEmail(toEmail,name,otp);
        htmlMailSender(toEmail,"Verify Your TalentPrep Account Password",html);

    }


    private void htmlMailSender(String toEmail,String subject,String html){
        try{
            MimeMessage mimeMessage =mailSender.createMimeMessage();
            MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true,"UTF-8");
            helper.setTo(toEmail);
            helper.setFrom(fromEmail);
            helper.setSubject(subject);
            helper.setText(html,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            throw new RuntimeException("Failed to Send Email",ex);
        }
    }
}
