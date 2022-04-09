package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource2;

import org.springframework.stereotype.Service;

@Service(value = "123")
public class ResourceService2 implements ResourceService {
    @Override
    public String satHello(String name) {
        return "HelloService2:" + name;
    }
}
