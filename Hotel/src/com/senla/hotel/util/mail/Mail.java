package com.senla.hotel.util.mail;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class Mail implements IMail {
    private static final String PATH_TO_PROPERTIES_OF_FIELD = "Hotel/src/com/senla/hotel/resources/mail.properties";
    private static Properties propMail = new Properties();
    private Thread thread;

    @Autowired(className = "ServiceImpl")
    private IService service;

    public void sendMail() throws IOException {
        FileInputStream fileInputStreamField = new FileInputStream(PATH_TO_PROPERTIES_OF_FIELD);
        propMail.load(fileInputStreamField);

        thread = new Thread(() -> {
            String to = propMail.getProperty("to");       // sender email
            String from = propMail.getProperty("from");   // receiver email

            // предустановки
            Properties properties = System.getProperties();
            properties.put("mail.smtp.auth", propMail.getProperty("auth"));
            properties.put("mail.smtp.starttls.enable", propMail.getProperty("starttls.enable"));
            properties.put("mail.smtp.port", propMail.getProperty("port"));
            properties.put("mail.smtp.host", propMail.getProperty("host"));
            properties.put("mail.smtp.socketFactory.class", propMail.getProperty("class"));

            // данные отправителя
            final String senderUsername = propMail.getProperty("senderUsername");
            final String senderPassword = propMail.getProperty("senderPassword");

            // аутентификация
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(senderUsername, senderPassword);
                        }
                    });

            while (true) {
                try {
                    // создание сообщения
                    MimeMessage message = new MimeMessage(session);
                    // отправитель
                    message.setFrom(new InternetAddress(from));
                    // получатель
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    // заголовок
                    message.setSubject("Data from Hotel");
                    // текст сообщения
                    message.setText("Number of busy rooms: " + service.getRoomGeneral().getRooms().stream().filter(
                            c -> c.getIdGuest() != null).count() + "\n" +
                            "Number of waiting guests: " + service.getGuestGeneral().getGuests().stream().filter(
                            c -> c.getRoomNumber() == null).count());
                    // отправка
                    Transport.send(message);
                    Thread.sleep(Long.parseLong(propMail.getProperty("time")));
                } catch (MessagingException | InterruptedException mex) {
                    mex.printStackTrace();
                }
            }
        });

        thread.start();
    }

    @Override
    public void closeThread() {
        thread.interrupt();
    }
}

