package com.liuxx.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwesomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwesomeApplication.class, args);
    }
}
