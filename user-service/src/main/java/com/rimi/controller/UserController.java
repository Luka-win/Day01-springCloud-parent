package com.rimi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author luka
 * @version V1.0
 * @date 2021 2021/7/28 0028 10:06
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFailBack")
public class UserController {

    //@Autowired
    //private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 给login方法定义的异常降级方法，当login出异常后就会调用此方法
     * @return
     */
    public String failBack() {
        return "当前的服务忙，请稍后访问...";
    }

    public String failBackById(Integer id) {
        return "商品编号异常..." +id;
    }

    public String defaultFailBack() {
        return "当前的服务忙，请稍后访问...";
    }

    @HystrixCommand()
    @GetMapping("/user/{id}")
    public String getGoodsById(@PathVariable("id") Integer id) {
        String url = "http://PRODUCT-SERVICE/product/" + id;
        return restTemplate.getForObject(url,String.class);
    }

    @HystrixCommand(fallbackMethod = "failBack")
    @GetMapping("/user")
    public String login() {
        System.out.println("UserController.login---登录成功!!!");

        // 请求商品服务的相关数据
        // String url = "http://localhost:9999/product";
        // 获取对应的服务对象的列表清单
        //List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-SERVICE");
        //
        //// 自定义负载均衡，实现服务集群调用
        //int index = (int) (Math.random()*instances.size());
        //
        //// 获取对应的服务对象
        //ServiceInstance serviceInstance = instances.get(index);
        //// 从服务对象中获取地址和端口
        //System.out.println("serviceInstance.getUri() = " + serviceInstance.getUri());
        //System.out.println("serviceInstance.getHost() = " + serviceInstance.getHost());
        //System.out.println("serviceInstance.getPort() = " + serviceInstance.getPort());
        //
        //// 动态获取地址和端口，并拼接对应端口和资源路径
        //String url = serviceInstance.getUri() + "/product";

        // 默认的负载均衡是轮序
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT-SERVICE");

        System.out.println("serviceInstance.getUri() = " + serviceInstance.getUri());
        System.out.println("serviceInstance.getHost() = " + serviceInstance.getHost());
        System.out.println("serviceInstance.getPort() = " + serviceInstance.getPort());

        // 动态获取地址和端口，并拼接对应端口和资源路径
        //String url = serviceInstance.getUri() + "/product";
        String url = "http://PRODUCT-SERVICE/product";

        List forObject = restTemplate.getForObject(url, List.class);
        forObject.forEach(System.out::println) ;

        return "UserController.login---登录成功!!!从商品服务中获取数据:" + forObject;
    }

}
