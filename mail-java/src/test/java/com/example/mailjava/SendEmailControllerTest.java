package com.example.mailjava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class SendEmailControllerTest {
    @Autowired
    SendEmailController sendEmailController;

    @Test
    void sendEmail() throws Exception {
        MessageRQ messageRQ = new MessageRQ("");
        sendEmailController.sendEmail(messageRQ);
    }
}