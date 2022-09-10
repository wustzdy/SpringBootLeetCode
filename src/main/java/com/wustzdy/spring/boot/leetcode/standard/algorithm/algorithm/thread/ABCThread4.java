package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.Semaphore;

public class ABCThread4 {
    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(0);
    private static Semaphore semaphore3 = new Semaphore(0);

    private static final Thread thread1 = new Thread(() -> {
        try {
            semaphore1.acquire();
            System.out.println(Thread.currentThread().getName() + " 1");
            semaphore2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    private static final Thread thread2 = new Thread(() -> {
        try {
            semaphore2.acquire();
            System.out.println(Thread.currentThread().getName() + " 2");
            semaphore3.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    private static final Thread thread3 = new Thread(() -> {
        try {
            semaphore3.acquire();
            System.out.println(Thread.currentThread().getName() + " 3");
            semaphore1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) {
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
