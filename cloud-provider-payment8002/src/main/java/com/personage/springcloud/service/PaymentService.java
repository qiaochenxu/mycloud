package com.personage.springcloud.service;

import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
