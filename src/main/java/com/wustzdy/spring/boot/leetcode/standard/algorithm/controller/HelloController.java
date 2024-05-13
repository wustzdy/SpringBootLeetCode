package com.wustzdy.spring.boot.leetcode.standard.algorithm.controller;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/test")
    public String getTest() {
        return helloService.getTest();
    }

    @RequestMapping("/thread")
    public String processRequest(@RequestParam("input") String input) throws ExecutionException, InterruptedException {
        System.out.println("112333:" + input);
        // 使用CompletableFuture来异步执行服务层的方法，并获取结果
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> helloService.process(input));
        String string = future.get();
        System.out.println("string:" + string);

        return future.get(); // 阻塞等待结果，你可以根据需要选择其他方式处理异步结果
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
