package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.stereotype.Service;

@Service
public class UserService1 implements UserService {
    @Override
    public String satHello(String name) {
        return "HelloService1:" + name;
    }
}
