package com.personage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsulOrderController {
    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://consul-consumer-service";
    @GetMapping("consumer/payment/consul")
    public String consul(){
        String forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);

        return forObject;
    }
}
