package com.wustzdy.spring.boot.leetcode.standard.algorithm.thread;

import java.util.Arrays;
import java.util.List;

/**
 * 使用Lambda表达式并行计算
 * parallelStream
 *
 * @author fatah
 */
public class parallelStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        parallelStreamDemo demo = new parallelStreamDemo();
        int result = demo.add(list);
        System.out.println("计算后的结果为" + result);
    }

    public int add(List<Integer> list) {
        //若Lambda是串行执行,则应顺序打印
        list.parallelStream().forEach(System.out::println);
        //Lambda有stream和parallelSteam(并行)
        return list.parallelStream().mapToInt(i -> i).sum();
    }
}

/*
运行结果：
        4
        1
        3
        5
        6
        2
        计算后的结果为21
        事实证明是并行执行*/
