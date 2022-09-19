package com.example.testcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TestCoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCoinApplication.class, args);
    }

}
