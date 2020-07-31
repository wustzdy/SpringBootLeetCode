package com.wustzdy.spring.boot.leetcode.standard.algorithm.service.impl;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String getTest() {
        return "Hello world service";
    }
}
