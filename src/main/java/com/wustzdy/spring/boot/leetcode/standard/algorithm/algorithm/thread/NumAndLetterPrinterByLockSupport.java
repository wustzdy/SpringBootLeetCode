package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.locks.LockSupport;

//https://blog.csdn.net/qq_31960623/article/details/115793981
//比如，我们再解决下第五题：用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D…26Z。
public class NumAndLetterPrinterByLockSupport {
    private static Thread numThread, letterThread;

    public static void main(String[] args) {

        letterThread = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                LockSupport.unpark(numThread);
                LockSupport.park();
            }
        }, "letterThread");

        numThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.park();
                LockSupport.unpark(letterThread);
            }
        }, "numThread");
        numThread.start();
        letterThread.start();
    }
}
