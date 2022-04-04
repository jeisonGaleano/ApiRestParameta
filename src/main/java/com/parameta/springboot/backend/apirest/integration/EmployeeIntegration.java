package com.parameta.springboot.backend.apirest.integration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties("soap")
public class EmployeeIntegration {

    private String serviceUrl;
    private String pathEmployee;
    private String user;
    private String password;
    private String pathLogout;
	
	
}
