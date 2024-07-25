package com.example.mailjava;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
class SendEmailControllerTest {
    @Autowired
    SendEmailController sendEmailController;

    @Test
    void sendEmail() throws Exception {
        MessageRQ messageRQ = new MessageRQ(
                "Java",
                "KP",
                "kp@gmail.com",
                "Chaincue",
                "000 000 00 00",
                "1",
                "2023-05-20");
        sendEmailController.sendEmail(messageRQ);
    }
}