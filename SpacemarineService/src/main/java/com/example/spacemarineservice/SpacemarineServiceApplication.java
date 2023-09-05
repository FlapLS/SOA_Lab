package com.example.spacemarineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpacemarineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpacemarineServiceApplication.class, args);
    }

}
