package com.waitme.cloud.netflix.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class Application {

    @RequestMapping("eurekaService")
    public String eurekaService() {
        return "eureka service!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
