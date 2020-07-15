package com.ozymern.springmicroservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//para que detecte product commonds
@EntityScan({"com.ozymern.spring.microservices.commons.models.entity"})
public class SpringMicroservicesProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMicroservicesProductApplication.class, args);
    }

}
