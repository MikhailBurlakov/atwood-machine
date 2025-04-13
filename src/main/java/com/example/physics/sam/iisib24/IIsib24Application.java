package com.example.physics.sam.iisib24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.physics.sam.iisib24")
public class IIsib24Application {
    public static void main(String[] args) {
        SpringApplication.run(IIsib24Application.class, args);
    }
} 