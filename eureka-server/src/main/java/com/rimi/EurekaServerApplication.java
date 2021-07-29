package com.rimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author luka
 * @version V1.0
 * @date 2021 2021/7/28 0028 13:59
 */
@SpringBootApplication
// 开启eureka服务，让当前项目成为注册中心
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
