package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.zeroAndEven;

//启动两个线程交替顺序打印奇偶数
//启动两个线程交替打印1~100的奇偶数这种问题张口就来。
public class PrintZeroEvenOddForSynchronized {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        try {
            turning();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void turning() throws InterruptedException {
        new Thread(new TurningRunner(), "偶数").start();
        Thread.sleep(1);
        new Thread(new TurningRunner(), "奇数").start();
    }

    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 4) {
                //获取锁
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    //唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 4) {
                            //如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
/*
偶数:0
奇数:1
偶数:2
奇数:3
偶数:4*/
