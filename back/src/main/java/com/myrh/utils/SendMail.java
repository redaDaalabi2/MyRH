package com.myrh.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMail {

    private final JavaMailSender emailSender;
    private final String from = "daalabireda@gmail.com";

    public SendMail(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendVerificationCode(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }


}
