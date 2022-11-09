package com.personage.springcloud.service.impl;

import com.personage.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
    
        // 获取当前线程名称
        String name = Thread.currentThread().getName();
        return "线程池："+name +"paymentInfoOk,id:" + id +"\t" +"😀";
    }
    
    @Override
    public String paymentInfoTimeOut(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        return "线程池："+name +"paymentInfoTimeOut,id:" + id +"\t" +"😀 耗时："+time;
        
        //test
    }
}
