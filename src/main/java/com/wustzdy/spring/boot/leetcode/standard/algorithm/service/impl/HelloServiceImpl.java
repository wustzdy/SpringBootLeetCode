package com.wustzdy.spring.boot.leetcode.standard.algorithm.service.impl;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.service.HelloService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String getTest() {
        return "Hello world service";
    }

    @Override
    @Async // 标记该方法为异步执行
    public String process(String input) {
        System.out.println("input:" + input);
        // 模拟耗时操作
        try {
            Thread.sleep(2000); // 假设处理过程需要2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processed input: " + input);
        return "Processed input: " + input;
    }
}
