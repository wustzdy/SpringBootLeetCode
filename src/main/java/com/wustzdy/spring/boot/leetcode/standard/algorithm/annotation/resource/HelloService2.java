package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("HelloService2")
@Primary
public class HelloService2 implements HelloService {
    @Override
    public String satHello(String name) {
        return "HelloService2:" + name;
    }
}
