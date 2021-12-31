package com.personage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {
    public static void main(String[] args) {
        System.setProperty("zookeeper.sasl.client","false");
        SpringApplication.run(ZkOrderMain80.class,args);
    }
}
