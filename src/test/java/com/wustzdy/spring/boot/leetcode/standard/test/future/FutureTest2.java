package com.wustzdy.spring.boot.leetcode.standard.test.future;

import java.util.concurrent.*;

public class FutureTest2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask(() -> {
            try {
                System.out.println("���߳�����ִ�����񡣡���");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = 0;
            for (int i = 0; i <= 100; i++) {
                num += i;
            }
            return num;
        });
        service.submit(futureTask);
        service.shutdown();
        System.out.println("���߳�����ִ�����񡣡���");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //����ֱ���������
            System.out.println("-------------------------------------");
            System.out.println("ִ�н��Ϊ��" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("����ִ����ɡ�����");
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                System.out.println("���߳�����ִ�����񡣡���");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = 0;
            for (int i = 0; i <= 100; i++) {
                num += i;
            }
            return num;
        }
    }
}
//futureTask.get()ִ��ʱ����������Ѿ�ִ��������ֱ�ӷ���ִ�н����
//        ���û��ִ�������̻߳����������ֱ������ִ����ϡ���������get(long timeout, TimeUnit unit)����ȡִ�н���������ָ��ʱ���ڣ���û��ȡ���������ֱ�ӷ���null��
//        �ܵ���˵Futureģʽ��˼����������߳̽���ִ�е�ʱ�����̲߳���������ִ�С��ȵ����߳���Ҫ���̵߳Ľ����ʱ����ȥ��ȡ���̵߳Ľ��
//        ����ʱ���߳�û��ִ����ɵĻ��ͻ�����ֱ��ִ����ɣ������̻߳����Ը���һ����ҵ���߼�ȥ�ж��Ƿ�Ҫȡ��ִ�����̣߳�����������һ����ʱʱ�䡣
//        ������ʱ�䳬���˳�ʱʱ�����߳���Ȼû��ִ����ɵĻ�������ֱ�ӷ���null��