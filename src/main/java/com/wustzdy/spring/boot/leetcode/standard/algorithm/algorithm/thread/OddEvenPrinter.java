package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;
/*
同样的思路，来解决下第 2 题：两个线程交替打印奇数和偶数
        使用对象监视器实现，两个线程 A、B 竞争同一把锁，只要其中一个线程获取锁成功，就打印 ++i，并通知另一线程从等待集合中释放，然后自身线程加入等待集合并释放锁即可。
*/

public class OddEvenPrinter {
    private Object monitor = new Object();
    private final int limit;
    private volatile int count;

    OddEvenPrinter(int initCount, int times) {
        this.count = initCount;
        this.limit = times;
    }

    private void print() {

        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止有子线程被阻塞未被唤醒，导致主线程不退出
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) {

        OddEvenPrinter printer = new OddEvenPrinter(0, 10);
        new Thread(printer::print, "odd").start();
        new Thread(printer::print, "even").start();
    }
}
/*
线程[odd]打印数字:1
        线程[even]打印数字:2
        线程[odd]打印数字:3
        线程[even]打印数字:4
        线程[odd]打印数字:5
        线程[even]打印数字:6
        线程[odd]打印数字:7
        线程[even]打印数字:8
        线程[odd]打印数字:9
        线程[even]打印数字:10*/
