package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;

/**
 * 第二种创建启动线程的方式
 * 实现Runnale接口
 * 2、实现Runnable接口，重写run()
 *
 * @author wustzdy
 */
public class ThreadDemo1 implements Runnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo1());
        Thread thread2 = new Thread(new ThreadDemo1());
        thread1.start();
        thread2.start();

    }

    @Override
    public void run() {
        System.out.println("implements Runnable is running");
    }
}
//实现Runnable接口相比第一种继承Thread类的方式，使用了面向接口，将任务与线程进行分离，有利于解耦
