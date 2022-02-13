package com.wustzdy.spring.boot.leetcode.standard.algorithm.controller;

import com.alibaba.excel.EasyExcel;
import com.wustzdy.spring.boot.leetcode.standard.algorithm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/test")
    public String getTest() {
        return helloService.getTest();
    }

    public static void main(String[] args) {
        testBreak1();
    }

    private static void testBreak1() {
        System.out.println("--------测试continue-------");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println("i=" + i);
        }
    }

}
