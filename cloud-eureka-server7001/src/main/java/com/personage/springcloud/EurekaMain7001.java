package com.personage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 乔晨旭
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud
 * @CreateTime: 2021-11-25 22:58
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
