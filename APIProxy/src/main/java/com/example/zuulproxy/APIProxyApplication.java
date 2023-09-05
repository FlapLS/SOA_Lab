package com.example.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class APIProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIProxyApplication.class, args);
    }

}
