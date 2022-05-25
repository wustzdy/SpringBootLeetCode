package com.wustzdy.spring.boot.leetcode.standard.algorithm.future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class MyService {
    @Async
    public Future<String> JobOne() throws InterruptedException {
        System.out.println("开始执行任务一");
        long l1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long l2 = System.currentTimeMillis();
        System.out.println("任务一用时" + (l2 - l1));
        return new AsyncResult<String>("任务一完成");//可以使用try,catch定义在正常完成时返回一个success信息，出现异常时返回error信息。
    }

    @Async
    public Future<String> JobTwo() throws InterruptedException {
        System.out.println("开始执行任务二");
        long l1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long l2 = System.currentTimeMillis();
        System.out.println("任务二用时" + (l2 - l1));
        return new AsyncResult<String>("任务二完成");
    }


    @Async
    public Future<String> JobThree() throws InterruptedException {
        System.out.println("开始执行任务三");
        long l1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long l2 = System.currentTimeMillis();
        System.out.println("任务三用时" + (l2 - l1));
        return new AsyncResult<String>("任务三完成");
    }
}
