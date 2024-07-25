package com.example.mailjava;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "email")
@Setter
@Getter
public class EmailKeyProperties {
     String username;
     String password;
     String port;
     String host;
}
