package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;

public class CycleWait implements Runnable {
    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cyclewait = new CycleWait();
        Thread thread = new Thread(cyclewait);
        thread.start();
        // 主线程等待法，核心代码：当value为空时循环等待
        while (null == cyclewait.value) {
            Thread.sleep(100);
        }
        System.out.println("value：" + cyclewait.value);
    }
}
