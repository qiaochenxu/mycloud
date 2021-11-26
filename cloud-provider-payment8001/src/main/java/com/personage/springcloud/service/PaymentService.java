package com.personage.springcloud.service;

import com.personage.springcloud.dao.PaymentDao;
import com.personage.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.service
 * @CreateTime: 2021-11-13 03:03
 * @Description:
 */

public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(Long id);

}
