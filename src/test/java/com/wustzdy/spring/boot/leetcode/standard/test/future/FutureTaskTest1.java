package com.wustzdy.spring.boot.leetcode.standard.test.future;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.SpringBootMavenStandardApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMavenStandardApplication.class)
@Slf4j
public class FutureTaskTest1 {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + "--pre executions");
            Thread.sleep(5000);
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + ":" + "--post21 executions");
            return sum;

        });

        new Thread(task).start();
        System.out.println(Thread.currentThread().getName() + ":" + "Thread has started---");//主线程

        try {
            Thread.sleep(2000);//主线程睡眠2秒钟
            System.out.println(Thread.currentThread().getName() + ":" + " get finally result:" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + "--pre executions");
            Thread.sleep(5000);
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + ":" + "--post21 executions");
            return sum;

        });

        new Thread(task).start();
        System.out.println(Thread.currentThread().getName() + ":" + "Thread has started---");//主线程

        try {
            Thread.sleep(2000);//主线程睡眠2秒钟
            System.out.println(Thread.currentThread().getName() + ":" + " get finally result:" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//main:Thread has started---
//        Thread-0:--pre executions\ 会停留3秒
//        Thread-0:--post21 executions
//        main: get finally result:5050
//
//因为get()阻塞方法，导致主线程会停留