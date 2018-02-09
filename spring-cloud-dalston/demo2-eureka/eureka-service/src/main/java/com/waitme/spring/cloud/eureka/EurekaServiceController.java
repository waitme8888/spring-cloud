package com.waitme.spring.cloud.eureka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo2/service")
public class EurekaServiceController {

    @RequestMapping("test")
    public String test() {
        return "service";
    }
}
