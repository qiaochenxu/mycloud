package com.personage.springcloud.controller;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import com.personage.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public CommonResult create(@RequestBody Payment payment){
        CommonResult commonResult = CommonResult.sueecss();
        commonResult =  paymentService.create(payment);
        log.info("调用成功",commonResult);
        return commonResult;

    }
}
