package com.wmn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "spring-cloud-consul-producer")
@EnableFeignClients
@ComponentScan("com.wmn.demo.*")
public class ConsulExmConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate balanceRestTemplate(){
        return  new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsulExmConsumerApplication.class, args);
    }

}
