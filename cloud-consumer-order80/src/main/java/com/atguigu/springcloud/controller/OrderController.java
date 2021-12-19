package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by accumulate on 2021-12-08 22:38
 */
@Slf4j
@RestController
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001"; //单机版
    public static final String PAYMENT_URL="http://cloud-payment-service";

    @GetMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        System.out.println("create payment:"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String getPaymentZipkin(){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",String.class);
    }

}
