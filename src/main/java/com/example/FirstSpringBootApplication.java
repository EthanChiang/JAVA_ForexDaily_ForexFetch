package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // 啟用定時任務功能
public class FirstSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootApplication.class, args);
    }

}
