package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//实现 Callable 接口
//与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
public class CallableDemo implements Callable<String> {
    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + "执行了");
        return "执行成功!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> futureTask1 = new FutureTask<String>(callableDemo);
        FutureTask<String> futureTask2 = new FutureTask<String>(callableDemo);
        Thread thread0 = new Thread(futureTask1);
        Thread thread1 = new Thread(futureTask2);
        thread0.start();
        thread1.start();
        System.out.println(futureTask2.get());
        System.out.println(futureTask2.get());

    }
}

/*Thread-0执行了
        Thread-1执行了
        执行成功!
        执行成功!*/
