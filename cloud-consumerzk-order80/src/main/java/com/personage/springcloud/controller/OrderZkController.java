package com.personage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZkController {
    public static final String PAYMENT_URL = "http://zookeeper-Service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String zk() {
        String s = restTemplate.getForObject(PAYMENT_URL +"/payment/zk",String.class);
        return s;
    }
}
