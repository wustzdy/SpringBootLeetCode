package com.wustzdy.spring.boot.leetcode.standard.test;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.SpringBootMavenStandardApplication;
import com.wustzdy.spring.boot.leetcode.standard.algorithm.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMavenStandardApplication.class)
@Slf4j
public class AsyncTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void func4() {
        log.info(Thread.currentThread().getName() + ": before call async function.");
        asyncService.test4();
        log.info(Thread.currentThread().getName() + ": after call async function.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("sleep error.");
        }
        log.info(Thread.currentThread().getName() + ": func end.");
    }
}
/*
    自定义一个线程池执行器代替默认的执行器
            自定义的线程池执行器*/

/* main: before call async function.
 main: after call async function.
: async-task-thread-pool-1: in test4, before sleep.
 async-task-thread-pool-1: in test4, after sleep.*/
