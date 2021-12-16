package com.atguigu.springcloud;

import com.netflix.client.IClient;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by accumulate on 2021-12-10 20:28
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
//        Client client=new LoadBalancerFeignClient();
//        IClient iClient = new FeignLoadBalancer();
//        ILoadBalancer iLoadBalancer=new ZoneAwareLoadBalancer<>();
    }
}
