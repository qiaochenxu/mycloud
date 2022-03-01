package com.personage.springcloud.controller;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import com.personage.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.conteroller
 * @CreateTime: 2021-11-13 03:14
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    // 服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create( @RequestBody Payment payment) {
        CommonResult commonResult = CommonResult.sueecss();
        int i = paymentService.create(payment);
        log.info("****插入结果:"+i);
        if (i>0) {
            commonResult.setMessage("插入成功，post：{"+serverPort+"}");
            commonResult.setData(i);
        } else {
            commonResult.setCode(-1);
            commonResult.setMessage("插入失败");
            commonResult.setData(null);
        }
        return commonResult;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        CommonResult commonResult = CommonResult.sueecss();
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果:{}",paymentById);
        if (paymentById == null){
            commonResult.setCode(-1);
            commonResult.setMessage("查询失败");
            commonResult.setData(null);
        } else {
            commonResult.setMessage("查询成功，post：{"+serverPort+"}");
            commonResult.setData(paymentById);
        }
        return commonResult;
    }

    /**
     * 服务发现
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(">>>>service:{}<<<<",service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            log.info(">>>>>>instance:{}<<<<<<",instance);
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
