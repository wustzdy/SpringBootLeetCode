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
public class FutureTaskTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(() -> {
            System.out.println("--pre executions");
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            System.out.println("--post21 executions");
            return sum;

        });

        new Thread(task).start();
        System.out.println("Thread has started---");//Ö÷Ïß³Ì

        try {
            System.out.println(" get finally result:" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
//--pre executions
//        --post21 executions
//        Thread has started---
//        get finally result:5050