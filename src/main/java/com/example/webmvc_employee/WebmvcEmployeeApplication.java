package com.example.webmvc_employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebmvcEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebmvcEmployeeApplication.class, args);
        System.out.println("여기가 메인이다");
    }

}
