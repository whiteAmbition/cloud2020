package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by accumulate on 2021-12-12 21:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZkMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class,args);
    }
}
