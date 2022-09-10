package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;

/**
 * 创建启动线程的第三种方式————匿名内部类
 *
 * @author fatah
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //方式1：相当于继承了Thread类，作为子类重写run()实现
        new Thread() {
            public void run() {
                System.out.println("extends Thread 匿名内部类创建线程方式1...");
            }
        }.start();

        ////方式2:实现Runnable,Runnable作为匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("implement runnable 匿名内部类创建线程方式2...");
            }
        }).start();
    }
}
