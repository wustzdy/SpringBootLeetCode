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
     * ���ò�ͬ����첽����
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
//��ִ�н�����Կ�����main�߳��е�func1�����ڵ����첽����test2��û�еȴ�test2����ִ����ɣ�ֱ��ִ�к���Ĵ��롣


/*
�������func1��������첽����test2������ͬһ������
��ʧЧ main�߳��е�func2�����ڵ����첽����test2�����󣬵ȴ�test2����ִ����󣬲ż�������ִ�С�
��һ��� ��ͬһ����������@Transactionһ��*/
