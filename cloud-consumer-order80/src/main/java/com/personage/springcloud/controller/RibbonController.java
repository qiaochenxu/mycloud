package com.personage.springcloud.controller;

import com.personage.springcloud.Utils.LadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

// ribbon 负载均衡
@RestController
public class RibbonController {

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LadBalancer ladBalancer;
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping(value = "/payment",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if (instances == null || instances.size()<= 0) {
            return null;
        }
        ServiceInstance instance = ladBalancer.instance(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }


}
