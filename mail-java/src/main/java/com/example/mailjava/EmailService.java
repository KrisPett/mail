package com.example.mailjava;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@AllArgsConstructor
public class EmailService {
    EmailKeyProperties emailKeyProperties;

    public void sendMail(String course, String email, String company, String phone, String participantsDesired, String date) throws Exception {
        String username = emailKeyProperties.getUsername();
        String password = emailKeyProperties.getPassword();
        String host = emailKeyProperties.getHost();
        String port = emailKeyProperties.getPort();

        Properties prop;
        prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("mailtrap@demomailtrap.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("koffep@gmail.com"));
        message.setSubject("Register Interest");

        String msg = String.format(
                "Course: %s<br>" +
                        "Email: %s<br>" +
                        "Company: %s<br>" +
                        "Phone: %s<br>" +
                        "Participants Desired: %s<br>" +
                        "Date: %s",
                course, email, company, phone, participantsDesired, date
        );

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        message.setContent(multipart);

        Transport.send(message);
    }

}