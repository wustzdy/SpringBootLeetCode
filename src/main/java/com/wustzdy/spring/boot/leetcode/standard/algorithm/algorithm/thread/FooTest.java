package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;
//1114. 按序打印
/*三个不同的线程 A、B、C 将会共用一个 Foo 实例。

        线程 A 将会调用 first() 方法
        线程 B 将会调用 second() 方法
        线程 C 将会调用 third() 方法
        请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/print-in-order
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class FooTest {
    private static AtomicInteger firstJobDone = new AtomicInteger(0);
    private static AtomicInteger secondJobDone = new AtomicInteger(0);

    public FooTest() {
    }

    public static void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public static void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public static void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }

    public static void main(String[] args) {
        Thread first = new Thread(() -> {
            try {
                FooTest.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        first.run();

        Thread second = new Thread(() -> {
            try {
                FooTest.first(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        second.run();

        Thread third = new Thread(() -> {
            try {
                FooTest.first(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        third.run();
    }
}
