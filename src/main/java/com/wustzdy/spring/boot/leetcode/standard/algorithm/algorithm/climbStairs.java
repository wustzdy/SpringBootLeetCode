package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.io.InputStream;
import java.util.Scanner;
/*题目描述

        一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

        思路解析

        第一步有n种跳法：跳1级、跳2级、到跳n级
        跳1级，剩下n-1级，则剩下跳法是f(n-1)
        跳2级，剩下n-2级，则剩下跳法是f(n-2)
        所以f(n)=f(n-1)+f(n-2)+...+f(1)
        因为f(n-1)=f(n-2)+f(n-3)+...+f(1)

        所以f(n)=2*f(n-1)*/
//爬楼梯
public class climbStairs {
    public static void main(String[] args) {
        System.out.println("请输入台阶数：");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("跳法总数：" + "\n" + getClimbStairsLayer(n));
    }

    private static int getClimbStairsLayer(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return getClimbStairsLayer(n - 1) + getClimbStairsLayer(n - 2);
        }
    }
}

//假设爬三阶楼梯
/*
那么有两种方案
A,假设先跳1级，那么剩下的 2层，3层楼，
           有两种跳法，要么是一次跳1级，也就是先跳2层，再跳3层，
                     要么是一次跳2级，也就是一次性跨两步，就是跨2层
           综上所述：有2种方法
B,假设先跳2级，那么剩下的1层，那么只有1种跳法，也就是直接跳到3层

综合A，B两种选择 最后有3种方法
*/
