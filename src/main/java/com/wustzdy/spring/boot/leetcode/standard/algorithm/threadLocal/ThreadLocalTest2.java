package com.wustzdy.spring.boot.leetcode.standard.algorithm.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest2 {
    private static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();

        threadLocal.set(Boolean.TRUE);

        service.execute(() -> {
            System.out.println(threadLocal.get());
        });

        service.shutdown();
    }
}
//null
/*
场景二：线程间通过 ThreadLocal 传递值
        子线程是否可以继承主线程的 threadLocal 变量呢？下面的代码中主线程为 threadLocal 设置为 true，
        子线程不修改 threadLocal 直接获取值，但是获取到的是 null，说明子线程并不会继承主线程的 threadLocal 变量。*/
