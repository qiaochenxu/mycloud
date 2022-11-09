package com.personage.springcloud.service;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);
    
    
    @GetMapping(value = "/payment/feign/timeout")
    String  paymentFeignTimeOut();
}
