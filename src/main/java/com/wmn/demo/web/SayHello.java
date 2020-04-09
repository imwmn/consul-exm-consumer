package com.wmn.demo.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: wmn
 * @Date: 2020/4/7 16:27
 */
@FeignClient("spring-cloud-consul-producer")
public interface SayHello {

    @GetMapping("/test/hello")
    String say();
}
