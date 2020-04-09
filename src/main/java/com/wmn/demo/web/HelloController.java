package com.wmn.demo.web;

import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @Author: wmn
 * @Date: 2020/4/3 16:19
 */
@RestController

public class HelloController {


    @Autowired
    private LoadBalancerClient loadBalanacer;

    @Autowired
    private DiscoveryClient discoverClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private SayHello sayHello;

    /**
     * 获取所有的服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoverClient.getInstances("spring-cloud-consul-producer");
    }

    @RequestMapping("/discover")
    public Object discover() {
        //String s = loadBalanacer.choose("spring-cloud-consul-producer").getUri().toString();
        //ServiceInstance choose = loadBalanacer.choose("spring-cloud-consul-producer");

//        System.out.println(choose.getUri());
//        System.out.println(choose.getServiceId().toString());
//        System.out.println(choose.getInstanceId());
//        System.out.println(choose.getHost());
//        System.out.println(choose.getUri()+"/test/hello");
        String forObject = restTemplate.getForObject("http://spring-cloud-consul-producer"+"/test/hello", String.class);


        return forObject ;
    }


    @RequestMapping("/say")
    public String hello() {
        return sayHello.say();
    }

}
