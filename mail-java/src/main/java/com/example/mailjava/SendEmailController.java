package com.example.mailjava;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("send-email")
@RestController
@RequiredArgsConstructor
public class SendEmailController {
    private final EmailService sendEmailService;

    @PostMapping
    public String sendEmail(@RequestBody MessageRQ messageRQ) throws Exception {
        sendEmailService.sendMail(
                messageRQ.course(),
                messageRQ.email(),
                messageRQ.company(),
                messageRQ.phone(),
                messageRQ.participantsDesired(),
                messageRQ.date());
        return "send email completed";
    }
}

