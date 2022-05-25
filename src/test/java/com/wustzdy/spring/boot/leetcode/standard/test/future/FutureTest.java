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
        System.out.println("��ʼ����");
        long l1 = System.currentTimeMillis();
        Future<String> r1 = myService.JobOne();
        Future<String> r2 = myService.JobTwo();
        Future<String> r3 = myService.JobThree();
//        String result2 = r2.get(50, TimeUnit.MILLISECONDS);
//        System.out.println("ʹ���в�get()�õ��ķ���ֵ" + result2);
        while (true) {//��ѭ����ÿ��2000msִ��һ�Σ��ж�һ���������첽���õķ����Ƿ�ȫ��ִ�����ˡ�
            if (r1.isDone() && r2.isDone() && r3.isDone()) {//ʹ��Future��isDone()�������ظ÷����Ƿ�ִ�����
                //����첽����ȫ��ִ���꣬����ѭ��
                break;
            }
            Thread.sleep(2000);//ÿ��2000�����ж�һ��
        }
        long l2 = System.currentTimeMillis();//����whileѭ��ʱ˵����ʱ�����첽���õķ�����ִ������ˣ���ʱ�õ���ǰʱ��

        String result = r1.get();
		/*
		 * String result2 = r2.get(50, TimeUnit.MILLISECONDS);
		   System.out.println("ʹ���в�get()�õ��ķ���ֵ"+result2);
		   �ʼ��ʵ���ʱ��������仰�����������һֱ���Բ�������ʱ�쳣��
		   �����ŷ��ְѳ�ʱ������whileѭ���ж��Ѿ��������֮����ô��ʱ���õ�Ȼ�Ͳ��������ˣ�
		   ���Է�������Ҳ�Ͳ�����ֳ�ʱ�쳣��Ӧ�÷���whileѭ��֮ǰ��������ʼִ��֮��Ͷ���ִ��ʱ�����г�ʱ���òŻ��ʱ���������������á�
		 */
        System.out.println("��������,��ʱ" + (l2 - l1));
        System.out.println("ʹ��get������õķ�������:" + result);

    }

}
