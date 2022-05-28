package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource3;

import org.springframework.stereotype.Service;

@Service
public class Resource3Service2 implements Resource3Service {
    @Override
    public String satHello(String name) {
        return "Hello--Resource3Service2:" + name;
    }
}
