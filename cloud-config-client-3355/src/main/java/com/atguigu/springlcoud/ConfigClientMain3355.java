package com.atguigu.springlcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientMain3355 {

    //实现动态刷新配置步骤：
    //1、添加spring-boot-starter-actuator依赖
    //2、引入配置的地方增加@RefreshScope注解
    //3、修改yml，暴露端口
    //4、发送post请求刷新3355配置：curl -X POST "http://localhost:3355/actuator/refresh"

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
