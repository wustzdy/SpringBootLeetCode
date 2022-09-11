package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.zeroAndEven;

import java.util.function.IntConsumer;

/*lambda表达式——IntConsumer接口
 * IntConsumer是一个功能接口
 * public interface IntConsumer
 * 表示接受单个int参数int返回任何结果的操作
 * 这是一个functional interface，其功能方法是accept(int) 。
 *
 * */
public class IntConsumerDemo {
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
    public static void main(String[] args) {
        repeat(4, i -> System.out.println("Countdown: " + (4 - i)));
    }
}
/*Countdown: 4
Countdown: 3
Countdown: 2
Countdown: 1*/
