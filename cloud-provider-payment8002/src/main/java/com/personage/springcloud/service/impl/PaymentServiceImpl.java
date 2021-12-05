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
    public CommonResult create(Payment payment) {
        CommonResult commonResult = CommonResult.sueecss();
        int i = paymentDao.create(payment);
        if (i >0) {
            commonResult.setData(i);
        } else {
            commonResult.setCode(-1);
            commonResult.setMessage("添加失败");
            commonResult.setData(i);
        }

        return commonResult;
    }
}
