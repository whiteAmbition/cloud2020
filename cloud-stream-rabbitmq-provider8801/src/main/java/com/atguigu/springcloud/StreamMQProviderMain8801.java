package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class StreamMQProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQProviderMain8801.class,args);
    }
}
