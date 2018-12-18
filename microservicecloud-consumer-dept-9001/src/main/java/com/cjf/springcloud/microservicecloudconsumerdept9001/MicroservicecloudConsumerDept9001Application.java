package com.cjf.springcloud.microservicecloudconsumerdept9001;

import MySelfRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class MicroservicecloudConsumerDept9001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConsumerDept9001Application.class, args);
    }
}
