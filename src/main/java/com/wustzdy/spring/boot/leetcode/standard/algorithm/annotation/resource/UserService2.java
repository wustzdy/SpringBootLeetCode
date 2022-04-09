package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.stereotype.Service;

@Service
public class UserService2 implements UserService {
    @Override
    public String satHello(String name) {
        return "HelloService2:" + name;
    }
}
