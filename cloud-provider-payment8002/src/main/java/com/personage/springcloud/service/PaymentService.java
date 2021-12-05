package com.personage.springcloud.service;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;

public interface PaymentService {
    public CommonResult create(Payment payment);
}
