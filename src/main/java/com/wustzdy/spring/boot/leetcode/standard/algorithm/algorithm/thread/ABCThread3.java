package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.Semaphore;

//实现 3 个线程 A、B、C，A 线程持续打印“A”，B 线程持续打印“B”，C 线程持续打印“C”，
// 启动顺序是线程 C、线程 B、线程 A，打印的结果是：ABC。
public class ABCThread3 {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(1);
    private static Semaphore semaphoreC = new Semaphore(1);

    private static final Thread threadA = new Thread(() -> {
        try {
            semaphoreA.acquire();//计数器就减1
            System.out.println("A");//计数器就加1
            semaphoreB.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    private static final Thread threadB = new Thread(() -> {
        try {
            semaphoreB.acquire();
            System.out.println("B");
            semaphoreC.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    private static final Thread threadC = new Thread(() -> {
        try {
            semaphoreC.acquire();
            System.out.println("C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) throws InterruptedException {
        semaphoreB.acquire();
        semaphoreC.acquire();
        threadC.start();
        threadB.start();
        threadA.start();
    }
}
//代码中执行前先执行了semaphoreB.acquire();和semaphoreC.acquire();，
//        是为了将B和C的信号释放，这个时候，就能够阻塞B线程、C线程中信号量的获取，直到顺序获取了信号值。

/*

最简单的理解信号量就是，一个计数器、一个等待队列、两个方法（在Java实现的Semaphore中就是acquire和release）。
        调用一次acquire方法，计数器就减1，如果此时计数器小于0，则阻塞当前线程，否则当前线程可继续执行。
        调用一次release方法，计数器就加1，如果此时计数器小于等于0，则唤醒一个等待队列中的线程，并将其中等待队列中移除。
        ————————————————
        版权声明：本文为CSDN博主「码拉松」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/CSDN_WYL2016/article/details/123810014*/
