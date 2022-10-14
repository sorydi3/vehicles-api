package com.udacity.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Creates a Spring Boot Application to run the Pricing Service.
 * DONE: Convert the application from a REST API to a microservice.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class PricingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

}
