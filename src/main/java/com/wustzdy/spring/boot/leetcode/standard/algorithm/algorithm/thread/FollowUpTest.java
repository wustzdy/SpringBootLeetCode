package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.CountDownLatch;

//顺序打印123
//按顺序打印 123 123 123
//有这么一个多线程场景问题：有三个线程，线程1执行完成之后线程2执行，线程2执行完之后线程3执行，
//线程3执行完成之后线程1执行，整体循环50次，写程序实现
public class FollowUpTest {
    public static void main(String[] args) throws InterruptedException {
        FollowUpTest handler = new FollowUpTest();
        for (int i = 0; i < 50; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(3);
            run(countDownLatch);
            countDownLatch.await();
            System.out.println();
        }
    }

    private static void run(CountDownLatch countDownLatch) {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.print("1");
                    countDownLatch.countDown();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.print("2");
                    countDownLatch.countDown();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.print("3");
                    countDownLatch.countDown();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }


    static class Foo {
        CountDownLatch latch12 = new CountDownLatch(1);
        CountDownLatch latch23 = new CountDownLatch(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            latch12.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            latch12.await();
            printSecond.run();
            latch23.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            latch23.await();
            printThird.run();
        }
    }
}
