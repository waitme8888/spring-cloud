package com.waitme.cloud.eureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
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
//    @HystrixCommand(fallbackMethod="callServiceFail")
    public String callEurekaService() {
        String str = restTemplate.getForEntity("http://EUREKA-CLIENT-SERVICE/eurekaService", String.class).getBody();
        return str;
    }

    public String callServiceFail() {
        return "call eureka service fail";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
