package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
    }

    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(0);
    private static Semaphore s3 = new Semaphore(0);

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                try {
                    s1.acquire();
                    System.out.printf("%s", "1");
                    s2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                try {
                    s2.acquire();
                    System.out.printf("%s", "2");
//                    s3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    static class Thread3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                try {
                    s3.acquire();
                    System.out.printf("%s", "3");
//                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
