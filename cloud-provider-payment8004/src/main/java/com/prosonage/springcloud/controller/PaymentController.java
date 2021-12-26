package com.prosonage.springcloud.controller;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j

public class PaymentController {
    @Value("${server.port}")
    private String post;

    public String zk() {
        String s = post+ UUID.randomUUID().toString();
        return s;
    }


//    @RequestMapping(value = "/payment/create",
//            method = RequestMethod.POST,
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    public CommonResult create(@RequestBody Payment payment) {
//        CommonResult commonResult = CommonResult.sueecss();
//        log.info("zje");
//
//        return commonResult;
//
//    }
}
