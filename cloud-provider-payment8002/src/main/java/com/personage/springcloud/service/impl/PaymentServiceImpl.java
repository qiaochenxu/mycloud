package com.personage.springcloud.service.impl;

import com.personage.springcloud.dao.PaymentDao;
import com.personage.springcloud.entities.Payment;
import com.personage.springcloud.result.CommonResult;
import com.personage.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.service.impl
 * @CreateTime: 2021-12-02 09:40
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        CommonResult commonResult = CommonResult.sueecss();
        paymentDao.create(payment);


        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        paymentDao.getPaymentById(id);

        return paymentDao.getPaymentById(id);
    }
}
