package com.wustzdy.spring.boot.leetcode.standard.algorithm.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {
    @Async("asyncTaskExecutor")
    public void test4() {
        try {
            log.info(Thread.currentThread().getName() + ": in test4, before sleep.");
            Thread.sleep(2000);
            log.info(Thread.currentThread().getName() + ": in test4, after sleep.");
        } catch (InterruptedException e) {
            log.error("sleep error.");
        }
    }

    @Async
    public void test2() {
        try {
            log.info(Thread.currentThread().getName() + " in test2, before sleep.");
            Thread.sleep(2000);
            log.info(Thread.currentThread().getName() + " in test2, after sleep.");
        } catch (InterruptedException e) {
            log.error("sleep error.");
        }
    }
}
