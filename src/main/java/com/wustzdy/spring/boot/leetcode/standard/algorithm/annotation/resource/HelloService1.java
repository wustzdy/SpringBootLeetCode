package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("HelloService1")
@Primary
public class HelloService1 implements HelloService {
    @Override
    public String satHello(String name) {
        return "HelloService1:" + name;
    }
}
