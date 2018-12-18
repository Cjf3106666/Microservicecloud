package com.cjf.springcloud.microservicecloudconsumerdept9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.lenovo")
@EnableFeignClients(basePackages = {"com.lenovo.microservicecloudapi"})
public class MicroservicecloudConsumerDept9002Application{

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConsumerDept9002Application.class, args);

    }
}
