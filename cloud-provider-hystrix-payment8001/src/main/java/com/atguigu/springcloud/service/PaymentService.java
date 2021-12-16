package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_OK,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler",commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
//        int age=10/0;//测试异常触发hystrix-fallback
        int sleepSeconds=3;
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(sleepSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_Timeout,id:"+id+"\t"+"O(∩_∩)O哈哈~"+" 耗时（秒）："+sleepSeconds;
    }

    public String paymentInfo_Timeout_Handler(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"  8001系统繁忙或者运行报错，请稍后再试，id:"+id+"\t"+"~~(>_<)~~呜呜";
    }

}
