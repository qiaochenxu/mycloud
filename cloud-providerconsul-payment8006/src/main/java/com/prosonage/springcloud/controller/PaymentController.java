package com.prosonage.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @GetMapping("payment/consul")
    public String consul() {
        String s = "端口号为："+port +"随机数："+ UUID.randomUUID().toString();
        return s;
    }
}
