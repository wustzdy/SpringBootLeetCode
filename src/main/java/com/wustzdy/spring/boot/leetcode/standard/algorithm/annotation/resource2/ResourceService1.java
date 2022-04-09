package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource2;

import org.springframework.stereotype.Service;

@Service
public class ResourceService1 implements ResourceService {
    @Override
    public String satHello(String name) {
        return "HelloService1:" + name;
    }
}
