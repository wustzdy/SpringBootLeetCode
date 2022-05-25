package com.wustzdy.spring.boot.leetcode.standard.algorithm.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    private static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();

        threadLocal.set(Boolean.TRUE);

        service.execute(() -> {
            threadLocal.set(Boolean.FALSE);
            System.out.println("子线程设置为：" + threadLocal.get());
        });
        System.out.println("主线程设置为：" + threadLocal.get());
        service.shutdown();
    }
}
/*场景一：应用于变量在线程间隔离而在方法或类间共享的场景
        通过下面的这个测试用例可以看到，
        主线程和子线程分别设置 threadLocal 变量的值为 true 和 false
        ，但是并没有带来冲突所以是线程安全的。*/
/*
主线程设置为：true
        子线程设置为：false*/
