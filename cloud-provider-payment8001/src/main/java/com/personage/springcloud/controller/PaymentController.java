package com.personage.springcloud.controller;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import com.personage.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.conteroller
 * @CreateTime: 2021-11-13 03:14
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/creater")
    public CommonResult create( @RequestBody Payment payment) {
        CommonResult commonResult = CommonResult.sueecss();
        int i = paymentService.create(payment);
        log.info("****插入结果:"+i);
        if (i>0) {
            commonResult.setData(i);
        } else {
            commonResult.setCode(-1);
            commonResult.setMessage("插入失败");
            commonResult.setData(null);
        }
        return commonResult;
    }
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
            commonResult.setData(paymentById);
        }
        return commonResult;
    }
}
