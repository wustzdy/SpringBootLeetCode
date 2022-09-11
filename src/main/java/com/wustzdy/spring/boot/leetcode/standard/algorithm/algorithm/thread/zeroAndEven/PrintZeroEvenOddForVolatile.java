package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.zeroAndEven;

//启动两个线程交替顺序打印奇偶数
//启动两个线程交替打印1~100的奇偶数这种问题张口就来。
/*通过一个volatile类型的变量控制
        该方式的思路是，线程在volatile变量上无限循环，直到volatile变量变为false。变为false后，
        线程开始真正地执行业务逻辑，打印数字，最后，需要挂起自己，并修改volatile变量，来唤醒其他线程。*/
public class PrintZeroEvenOddForVolatile {
    private static volatile int number = 1;
    private static final int MAX = 4;
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddThread());
        oddThread.setName("奇线程");
        oddThread.start();

        Thread evenThread = new Thread(new EvenThread());
        evenThread.setName("偶线程");
        evenThread.start();
    }
    /**
     * 奇数线程
     */
    static class OddThread implements Runnable {
        @Override
        public void run() {
            while (number < MAX) {
                while (flag) {
                    System.out.println(Thread.currentThread().getName() + "-->" + number);
                    number++;
                    flag = false;
                }
            }
        }
    }
    /**
     * 偶数线程
     */
    static class EvenThread implements Runnable {
        @Override
        public void run() {
            while (number <= MAX) {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + "-->" + number);
                    number++;
                    flag = true;
                }
            }
        }
    }
}
/*
奇线程-->1
偶线程-->2
奇线程-->3
偶线程-->4*/
