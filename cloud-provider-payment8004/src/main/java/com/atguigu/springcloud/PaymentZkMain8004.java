package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by accumulate on 2021-12-12 21:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZkMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentZkMain8004.class,args);
    }
}
