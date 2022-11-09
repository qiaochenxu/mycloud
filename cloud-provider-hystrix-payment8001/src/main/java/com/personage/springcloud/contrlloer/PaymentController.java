package com.personage.springcloud.contrlloer;

import com.personage.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.management.MemoryType;

/**
 * @author qcx
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    @RequestMapping(value = "/payment/ok/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String paymentInfoOk(@PathVariable("id") Integer id){
        
        String result = paymentService.paymentInfoOk(id);
        log.info(">>>>>>result:{}",result);
        return result;
    }
    
    @RequestMapping(value = "/payment/timeOut/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);
        log.info(">>>>>>result:{}",result);
        return result;
    }
}
