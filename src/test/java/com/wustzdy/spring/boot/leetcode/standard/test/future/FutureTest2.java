package com.wustzdy.spring.boot.leetcode.standard.test.future;

import java.util.concurrent.*;

public class FutureTest2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask(() -> {
            try {
                System.out.println("从线程正在执行任务。。。");
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
        System.out.println("主线程正在执行任务。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //阻塞直至任务完成
            System.out.println("-------------------------------------");
            System.out.println("执行结果为：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("任务执行完成。。。");
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                System.out.println("从线程正在执行任务。。。");
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
//futureTask.get()执行时如果该任务已经执行完了则直接返回执行结果，
//        如果没有执行完则线程会阻塞在这里，直至任务执行完毕。还可以用get(long timeout, TimeUnit unit)来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null。
//        总的来说Future模式的思想就是在子线程进行执行的时候，主线程不阻塞继续执行。等到主线程需要子线程的结果的时候再去获取子线程的结果
//        （此时子线程没有执行完成的话就会阻塞直至执行完成）。主线程还可以根据一定的业务逻辑去判断是否要取消执行子线程，还可以设置一个超时时间。
//        若阻塞时间超过了超时时间子线程仍然没有执行完成的话，可以直接返回null。