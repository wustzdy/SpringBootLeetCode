package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

//顺序打印 abc
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " first");
        });
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " second");
        });
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " third");
        });
        thread3.start();
        thread3.join();
    }
}
