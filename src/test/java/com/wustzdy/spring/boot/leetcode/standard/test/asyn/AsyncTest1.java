package com.wustzdy.spring.boot.leetcode.standard.test.asyn;

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
public class AsyncTest1 {
    @Autowired
    private AsyncService asyncService;

    /**
     * 调用不同类的异步方法
     */
    @Test
    public void func1() {
        log.info("before call async function.");
        asyncService.test2();
        log.info("after call async function.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("sleep error.");
        }
        log.info("func end.");
    }
}
  /*  before call async function.
        after call async function.
        SimpleAsyncTaskExecutor-1 in test2, before sleep
        SimpleAsyncTaskExecutor-1 in test2, after sleep.*/
//从执行结果可以看出，main线程中的func1方法在调用异步方法test2后，没有等待test2方法执行完成，直接执行后面的代码。


/*
如果方法func1和上面的异步方法test2方法在同一个类中
会失效 main线程中的func2方法在调用异步方法test2方法后，等待test2方法执行完后，才继续往后执行。
这一点和 在同一个类中事务@Transaction一样*/
