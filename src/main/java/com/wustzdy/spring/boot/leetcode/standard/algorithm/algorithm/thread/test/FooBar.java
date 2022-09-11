package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.test;

import java.util.concurrent.Semaphore;

//1115. 交替打印 FooBar
//两个不同的线程将会共用一个 FooBar 实例：
//        线程 A 将会调用 foo() 方法，而
//        线程 B 将会调用 bar() 方法
//        请设计修改程序，以确保 "foobar" 被输出 n 次。
//        示例 1：
//
//        输入：n = 1
//        输出："foobar"
//        解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
//        示例 2：
//
//        输入：n = 2
//        输出："foobarfoobar"
//        解释："foobar" 将被输出两次。
public class FooBar {
    private static Semaphore fooDone = new Semaphore(1);
    private static Semaphore barDone = new Semaphore(0);
    private static int n;

    public FooBar(int n) {
        this.n = n;
    }

    public static void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooDone.acquire();
            printFoo.run();
            barDone.release();
        }
    }

    public static void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barDone.acquire();
            printBar.run();
            fooDone.release();
        }
    }

    public static void main(String[] args) {
        new FooBar(3);
        Thread first = new Thread(() -> {
            try {
                FooBar.foo(() -> {
                    System.out.print("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        first.start();

        Thread second = new Thread(() -> {
            try {
                FooBar.bar(() -> {
                    System.out.print("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        second.start();
    }
}//firstsecondfirstsecondfirstsecond
