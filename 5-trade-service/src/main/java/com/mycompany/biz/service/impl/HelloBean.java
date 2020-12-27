package com.mycompany.biz.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

@Service

public class HelloBean {
    
    @SentinelResource
    public String sayHello() {
        return "hello world";
    }
    
}
