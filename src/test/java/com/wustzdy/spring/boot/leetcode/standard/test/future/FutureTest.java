package com.wustzdy.spring.boot.leetcode.standard.test.future;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.SpringBootMavenStandardApplication;
import com.wustzdy.spring.boot.leetcode.standard.algorithm.future.MyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMavenStandardApplication.class)
@Slf4j
public class FutureTest {

    @Autowired
    private MyService myService;

    @Test
    public void getInedx() throws InterruptedException, ExecutionException, TimeoutException, TimeoutException {
        System.out.println("开始访问");
        long l1 = System.currentTimeMillis();
        Future<String> r1 = myService.JobOne();
        Future<String> r2 = myService.JobTwo();
        Future<String> r3 = myService.JobThree();
//        String result2 = r2.get(50, TimeUnit.MILLISECONDS);
//        System.out.println("使用有参get()得到的返回值" + result2);
        while (true) {//死循环，每隔2000ms执行一次，判断一下这三个异步调用的方法是否全都执行完了。
            if (r1.isDone() && r2.isDone() && r3.isDone()) {//使用Future的isDone()方法返回该方法是否执行完成
                //如果异步方法全部执行完，跳出循环
                break;
            }
            Thread.sleep(2000);//每隔2000毫秒判断一次
        }
        long l2 = System.currentTimeMillis();//跳出while循环时说明此时三个异步调用的方法都执行完成了，此时得到当前时间

        String result = r1.get();
		/*
		 * String result2 = r2.get(50, TimeUnit.MILLISECONDS);
		   System.out.println("使用有参get()得到的返回值"+result2);
		   最开始在实验的时候把这两句话放在了这里，就一直测试不出来超时异常，
		   后来才发现把超时设置在while循环判断已经任务完成之后，那么超时设置当然就不起作用了，
		   所以放在这里也就不会出现超时异常，应该放在while循环之前即在任务开始执行之后就对其执行时长进行超时设置才会对时间真正起到限制作用。
		 */
        System.out.println("结束访问,用时" + (l2 - l1));
        System.out.println("使用get方法获得的返回内容:" + result);

    }

}
