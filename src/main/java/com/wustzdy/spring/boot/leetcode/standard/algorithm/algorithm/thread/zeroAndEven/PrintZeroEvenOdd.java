package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.zeroAndEven;

//启动两个线程交替顺序打印奇偶数
//启动两个线程交替打印1~100的奇偶数这种问题张口就来。
public class PrintZeroEvenOdd {
    private static volatile int number = 1;
    private static final int MAX = 10;

    public static void main(String[] args) {
        Object monitor = new Object();

        Thread oddThread = new Thread(new OddThread(monitor));
        oddThread.setName("奇线程");
        oddThread.start();

        Thread evenThread = new Thread(new EvenThread(monitor));
        evenThread.setName("偶线程");
        evenThread.start();
    }

    /**
     * 奇数线程
     */
    static class OddThread implements Runnable {
        private Object monitor;

        public OddThread(Object monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            while (number < MAX) {
                synchronized (monitor) {
                    while (number % 2 == 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "-->" + number);
                    number++;
                    monitor.notify();
                }
            }
        }
    }

    /**
     * 偶数线程
     */
    static class EvenThread implements Runnable {
        private Object monitor;

        public EvenThread(Object monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            while (number <= MAX) {
                synchronized (monitor) {
                    while (number % 2 != 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "-->" + number);
                    number++;
                    monitor.notify();
                }
            }
        }
    }
}
