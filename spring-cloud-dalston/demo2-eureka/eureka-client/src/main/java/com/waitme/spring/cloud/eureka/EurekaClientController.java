package com.waitme.spring.cloud.eureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("demo2/client")
public class EurekaClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test")
    @HystrixCommand(fallbackMethod="fallback")
    public String test() {
        return restTemplate.getForEntity("http://EUREKA-SERVICE/demo2/service/test",String.class).getBody();
    }

    public String fallback() {
        return "error";
    }


}
