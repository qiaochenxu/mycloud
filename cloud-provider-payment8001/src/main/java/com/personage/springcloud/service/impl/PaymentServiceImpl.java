package com.personage.springcloud.service.impl;

import com.personage.springcloud.dao.PaymentDao;
import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.service.impl
 * @CreateTime: 2021-11-13 03:04
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int create(@RequestBody Payment payment) {
        return paymentDao.create(payment);
    }
}
