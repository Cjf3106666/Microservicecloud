package com.cjf.springcloud.microservicecloudconfig3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Microservicecloudconfig3344Application {
    public static void main(String[] args) {
        SpringApplication.run(Microservicecloudconfig3344Application.class, args);
    }

}
