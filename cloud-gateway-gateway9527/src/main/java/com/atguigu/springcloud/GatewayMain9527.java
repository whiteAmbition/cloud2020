package com.atguigu.springcloud;

import com.atguigu.springcloud.filter.MyLogGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayMain9527.class, args);
        System.out.println(applicationContext.getBean(MyLogGatewayFilter.class));
    }
}
