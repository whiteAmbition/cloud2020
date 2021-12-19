package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigCenterMain3344 {

    //测试配置成功链接：
    //格式1、http://config3344.com:3344/master/config-dev.yml /${label}/${application}-${profile}.yml
    //格式2：http://config3344.com:3344/config/dev/master  /${application}-${profile}/${label}
    //格式3：http://config3344.com:3344/config-dev.yml  /${application}-${profile}.yml

    //【全部通知】修改完配置后，必须使用bus总线通知全部config-client： curl -X POST "http://localhost:3344/actuator/bus-refresh"
    //springCloudBus的exchange名
    //springCloudBus开头的队列名，如：springCloudBus.anonymous.7OjDv_XBQh6Lsgy2z2vn4w

    //【定点通知】curl -X POST "http://localhost:配置中心服务端端口号/actuator/bus-refresh/{destination}"
    ///bus/refresh请求不再发送到具体的服务实例上，而是发给config server并通过destination参数类指定需要更新配置的服务或实例
    //例：curl -X POST "http://localhost:3344/actuator/bus-refresh/cloud-config-client:3355"

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }

}
