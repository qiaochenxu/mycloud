package com.personage.springcloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.config
 * @CreateTime: 2021-11-16 23:45
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule iRule(){
//        // 随机
//        RandomRule randomRule = new RandomRule();
//        // 轮询
//        RoundRobinRule roundRobinRule = new RoundRobinRule();
//        // 先按照RoundRobinRule轮询策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
//        RetryRule retryRule = new RetryRule();
//        // 对RoundRobinRule轮询策略进行扩展，响应速度越快的实例选择权重越大，越容易被选择
//        WeightedResponseTimeRule weightedResponseTimeRule = new WeightedResponseTimeRule();
//        // 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//        BestAvailableRule bestAvailableRule = new BestAvailableRule();
//        // 先过滤掉故障实例，再选择并发较小实例
//        AvailabilityFilteringRule availabilityFilteringRule = new AvailabilityFilteringRule();
//        // 默认规则，复合判断server所在区域的性能和server的可用性选择服务器
//        ZoneAvoidanceRule zoneAvoidanceRule = new ZoneAvoidanceRule();
        return new RoundRobinRule();
    }
}
