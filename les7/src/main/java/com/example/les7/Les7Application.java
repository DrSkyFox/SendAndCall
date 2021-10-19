package com.example.les7;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Les7Application {

    public static void main(String[] args) {
        SpringApplication.run(Les7Application.class, args);
        log.info("Stopped");
    }

}
