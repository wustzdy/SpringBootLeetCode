package com.wustzdy.spring.boot.leetcode.standard.algorithm.threadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalDemo {
    private static ThreadLocal<String> localVar = new ThreadLocal<String>();
    public static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                ThreadLocalDemo.localVar.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());

            }
        }, "A").start();

        Thread.sleep(1000);
        new Thread(new Runnable() {
            public void run() {
                ThreadLocalDemo.localVar.set("local_B");
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        }, "B").start();
    }
}
/*
A :local_A
        after remove : null
        B :local_B
        after remove : null*/
//两个线程分表获取了自己线程存放的变量，他们之间变量的获取并不会错乱
