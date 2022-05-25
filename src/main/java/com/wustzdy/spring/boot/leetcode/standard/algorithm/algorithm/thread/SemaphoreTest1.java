package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.Semaphore;

//https://blog.csdn.net/qq_31960623/article/details/115793981
//https://blog.csdn.net/wat1r/article/details/119054576
//可以将acquire操作视为是消费一个许可，而release操作是创建一个许可

//先看下如何解决第一题：三个线程循环打印 A，B，C
/*使用Semaphore
        在信号量上我们定义两种操作：信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
        acquire(获取) 当一个线程调用 acquire 操作时，它要么通过成功获取信号量(信号量减1)，要么一直等下去，直到有线程释放信号量，或超时。
        release(释放)实际上会将信号量的值加1，然后唤醒等待的线程。*/
public class SemaphoreTest1 {
    public static void main(String[] args) {
        // 初始化许可数为1，A线程可以先执行
        Semaphore semaphoreA = new Semaphore(1);
        // 初始化许可数为0，B线程阻塞
        Semaphore semaphoreB = new Semaphore(0);
        // 初始化许可数为0，C线程阻塞
        Semaphore semaphoreC = new Semaphore(0);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    // A线程获得许可，同时semaphoreA的许可数减为0,进入下一次循环时
                    // A线程会阻塞，知道其他线程执行semaphoreA.release();
                    semaphoreA.acquire();
                    // 打印当前线程名称
                    System.out.print(Thread.currentThread().getName());
                    // semaphoreB许可数加1
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}
