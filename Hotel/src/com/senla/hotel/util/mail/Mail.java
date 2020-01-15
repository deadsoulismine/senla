package com.senla.hotel.util.mail;

import com.senla.hotel.util.DI.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class Mail implements IMail {
    public void sendMail() {
        String to = "javatestsenla1@outlook.com";       // sender email
        String from = "javatestsenla@outlook.com";      // receiver email
        String host = "SMTP.Office365.com";             // mail server host

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", host);

        final String username = "javatestsenla@outlook.com"; //change accordingly
        final String password = "753159op"; //change accordingly

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session); // email message

            message.setFrom(new InternetAddress(from)); // setting header fields

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Test Mail from Java Program"); // subject line

            // actual mail body
            message.setText("Ержан, алло блять, проперти настраивай, эээ...");
            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

 }

