package com.atguigu.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by accumulate on 2021-12-08 21:39
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
//        log.info("param payment:"+payment);
        Long result = paymentService.create(payment);
        //此处result还是返回1，但是我们传入的参数payment此时被mybatis修改主键从null变成4
        log.info("插入结果:"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败:"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("result:"+result);
        if(result!=null){
            return new CommonResult(200,"查询数据成功:"+serverPort,result);
        }else{
            return new CommonResult(444,"没有对应记录，查询id："+id+",serverPort:"+serverPort,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//["cloud-payment-service","cloud-order-service"]
        for (String service : services) {
            log.info("=======service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        log.info("instances:"+ JSON.toJSONString(instances));
        //[{"host":"192.168.31.84","instanceId":"payment8002","instanceInfo":{"actionType":"ADDED","appName":"CLOUD-PAYMENT-SERVICE","coordinatingDiscoveryServer":false,"countryId":1,"dataCenterInfo":{"name":"MyOwn"},"dirty":false,"healthCheckUrl":"http://192.168.31.84:8002/actuator/health","healthCheckUrls":["http://192.168.31.84:8002/actuator/health"],"homePageUrl":"http://192.168.31.84:8002/","hostName":"192.168.31.84","iPAddr":"192.168.31.84","id":"payment8002","instanceId":"payment8002","lastDirtyTimestamp":1639141999450,"lastUpdatedTimestamp":1639141999564,"leaseInfo":{"durationInSecs":90,"evictionTimestamp":0,"registrationTimestamp":1639141999564,"renewalIntervalInSecs":30,"renewalTimestamp":1639142119453,"serviceUpTimestamp":1639141999564},"metadata":{"management.port":"8002"},"overriddenStatus":"UNKNOWN","port":8002,"sID":"na","securePort":443,"secureVipAddress":"cloud-payment-service","status":"UP","statusPageUrl":"http://192.168.31.84:8002/actuator/info","vIPAddress":"cloud-payment-service","version":"unknown"},"metadata":{"$ref":"$[0].instanceInfo.metadata"},"port":8002,"secure":false,"serviceId":"CLOUD-PAYMENT-SERVICE","uri":"http://192.168.31.84:8002"},{"host":"192.168.31.84","instanceId":"payment8001","instanceInfo":{"actionType":"ADDED","appName":"CLOUD-PAYMENT-SERVICE","coordinatingDiscoveryServer":false,"countryId":1,"dataCenterInfo":{"name":"MyOwn"},"dirty":false,"healthCheckUrl":"http://192.168.31.84:8001/actuator/health","healthCheckUrls":["http://192.168.31.84:8001/actuator/health"],"homePageUrl":"http://192.168.31.84:8001/","hostName":"192.168.31.84","iPAddr":"192.168.31.84","id":"payment8001","instanceId":"payment8001","lastDirtyTimestamp":1639142012444,"lastUpdatedTimestamp":1639142012450,"leaseInfo":{"durationInSecs":90,"evictionTimestamp":0,"registrationTimestamp":1639142012450,"renewalIntervalInSecs":30,"renewalTimestamp":1639142012450,"serviceUpTimestamp":1639142012450},"metadata":{"management.port":"8001"},"overriddenStatus":"UNKNOWN","port":8001,"sID":"na","securePort":443,"secureVipAddress":"cloud-payment-service","status":"UP","statusPageUrl":"http://192.168.31.84:8001/actuator/info","vIPAddress":"cloud-payment-service","version":"unknown"},"metadata":{"$ref":"$[1].instanceInfo.metadata"},"port":8001,"secure":false,"serviceId":"CLOUD-PAYMENT-SERVICE","uri":"http://192.168.31.84:8001"}]
//        for (ServiceInstance instance : instances) {
//            log.info("=======instance:"+"\t"+instance.getInstanceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
//        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi,i'm paymentZipkin server fallback,welcome to zipkin，(●ˇ∀ˇ●) ";
    }

}
