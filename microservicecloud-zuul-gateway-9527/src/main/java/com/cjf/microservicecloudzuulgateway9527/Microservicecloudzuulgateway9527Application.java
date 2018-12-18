package com.cjf.microservicecloudzuulgateway9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Microservicecloudzuulgateway9527Application {

    public static void main(String[] args) {

        SpringApplication.run(Microservicecloudzuulgateway9527Application.class, args);
    }
}
