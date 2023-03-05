package com.example.seti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(value="com.example.seti.filter")
public class SetiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SetiApplication.class, args);
    }

}
