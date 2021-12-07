package com.personage.springcloud.controller;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import com.personage.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.controller
 * @CreateTime: 2021-12-01 23:49
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    public PaymentService paymentService;
    @RequestMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        CommonResult commonResult = CommonResult.sueecss();
        int i = paymentService.create(payment);
        log.info("插入结果:{}",i);
        if (i> 0){
            commonResult.setData(i);
        } else {
            commonResult.setCode(-1);
            commonResult.setMessage("未插入");
            commonResult.setData("null");
        }

        return commonResult;
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        CommonResult commonResult = CommonResult.sueecss();
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果:{}",paymentById);
        if (paymentById == null) {
            commonResult.setCode(-1);
            commonResult.setMessage("未查询到结果");
            commonResult.setData("null");
        } else {
            commonResult.setData(paymentById);
        }

        return commonResult;
    }


}
