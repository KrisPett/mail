package com.example.mailjava;

public record MessageRQ(
        String course,
        String name,
        String email,
        String company,
        String phone,
        String participantsDesired,
        String date
){}
