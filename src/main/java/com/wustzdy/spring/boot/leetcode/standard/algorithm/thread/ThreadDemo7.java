package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*6、线程池的实现(java.util.concurrent.Executor接口)
        降低了创建线程和销毁线程时间开销和资源浪费*/
public class ThreadDemo7 {
    public static void main(String[] args) {
        //创建带有5个线程的线程池
        //返回的实际上是ExecutorService,而ExecutorService是Executor的子接口
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running");
                }
            });
        }
    }
}
