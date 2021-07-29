package com.rimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 开启eureka客户端注解，当前的新版本(H版可以省略)
@EnableEurekaClient // 只能被eureka服务中心发现
@EnableDiscoveryClient // 通用的服务注册中心发现注解,可以支持其他的一些服务中心
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
