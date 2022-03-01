package com.personage.springcloud.Utils;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAtomicInteger(){
        int current;
        int next;
        do {
          current = this.atomicInteger.get();
          // 请求次数
          next = current>= 2147483647?0:current+1;
          // 比较并替代
        } while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }
    // 获取服务器有多少台
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAtomicInteger()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
