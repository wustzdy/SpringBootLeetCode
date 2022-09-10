package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;

//1、继承Thread类，重写run()方法
public class ThreadDemo2 extends Thread {
    public static void main(String[] args) {
        ThreadDemo2 demo1 = new ThreadDemo2();
        ThreadDemo2 demo2 = new ThreadDemo2();
        demo1.start();
        demo2.start();
    }

    //重写的是父类Thread的run()
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running...");
    }
}
