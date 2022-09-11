package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.zeroAndEven;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
//1116. 打印零与奇偶数
/*通过三个信号量来控制
        zero方法中的for表示要输出的0个次数，同时用来控制要唤醒偶数还是奇数方法
        even方法用来输出偶数同时唤醒zero方法
        odd方法用来输出奇数同时唤醒zero方法*/
/*修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
        实现 ZeroEvenOdd 类：
        ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
        void zero(printNumber) 调用 printNumber 以输出一个 0 。
        void even(printNumber) 调用printNumber 以输出偶数。
        void odd(printNumber) 调用 printNumber 以输出奇数。*/
/*示例 1：
        输入：n = 2
        输出："0102"
        解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
示例 2：
        输入：n = 5
        输出："0102030405" */

class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }//010203
}