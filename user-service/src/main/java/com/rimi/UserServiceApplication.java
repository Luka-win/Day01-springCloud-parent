package com.rimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableEurekaClient // 只能被eureka服务中心发现
//// @EnableDiscoveryClient // 通用的服务注册中心发现注解,可以支持其他的一些服务中心
//@EnableCircuitBreaker // 开启熔断服务
@SpringCloudApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    // 创建一个restTemplate模板对象注入到spring容器中
    @Bean
    @LoadBalanced // 添加这个注解，restTemplate自动有了负载均衡的功能
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
