package com.waitme.cloud.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private DiscoveryClient client;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("callEurekaService")
    public String callEurekaService() {
        String str = restTemplate.getForEntity("http://EUREKA-CLIENT-SERVICE/eurekaService", String.class).getBody();
        return str;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
