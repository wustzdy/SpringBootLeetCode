package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.primary;

import org.springframework.stereotype.Service;

@Service
public class HelloService1 implements HelloService {
    @Override
    public String satHello(String name) {
        return "HelloService1:" + name;
    }
}
