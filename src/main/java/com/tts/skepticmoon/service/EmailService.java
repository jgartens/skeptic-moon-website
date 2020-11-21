package com.tts.skepticmoon.service;

import com.tts.skepticmoon.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(User user){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("jacobgartenstein@gmail.com");
        msg.setSubject("New Skeptic Moon Contact");
        msg.setText(user.toString());

        javaMailSender.send(msg);
    }
    
}
