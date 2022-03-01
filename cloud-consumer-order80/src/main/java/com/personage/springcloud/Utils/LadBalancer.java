package com.personage.springcloud.Utils;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
