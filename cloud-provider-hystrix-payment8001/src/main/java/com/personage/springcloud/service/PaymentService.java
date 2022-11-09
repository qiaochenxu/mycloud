package com.personage.springcloud.service;

public interface PaymentService {
    String paymentInfoOk(Integer id);
    
    String paymentInfoTimeOut(Integer id);
}
