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
        System.out.println("跳法总数：" + "\n" + jumpFloor1(n));

    }

    //递归-递归法
    private static int getClimbStairsLayer(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return getClimbStairsLayer(n - 1) + getClimbStairsLayer(n - 2);
        }
    }

    /**
     * 非递归实现-迭代
     **/
    public static int JumpFloor(int target) {
        //青蛙跳台阶，一次可以跳上1级台阶，也可以跳上2级台阶
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        //一个n级台阶，第一次跳有两种选择，
        //一是第一次跳1级，那么跳法数目等于后面剩下的n-1级台阶的跳法数目
        //二是第一次跳2级，那么跳法数目等于后面剩下的n-2级台阶的跳法数目
        //一个n级台阶总的跳法数目为f(n-1) + f(n-2),相当于斐波那契数列
        int first = 1;
        int last = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = first + last;
            //将上次的last作为下一次的first
            first = last;
            //将上次的结果作为last
            last = sum;
        }
        return sum;
    }

    public static int jumpFloor(int number) {
        int[] dp = new int[number + 1];//如果不初始化dp[0]，那就存数组的时候从1开始
        if (number == 1) {  //如果数组下标从1开始，那么这里1的情况就要单独加进去
            return 1;
        }
        dp[1] = 1;//到第一个台阶
        dp[2] = 2;//到第二个台阶
        for (int i = 3; i < number + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number];
    }
    public static int jumpFloor1(int number) {
        int[] dp = new int[number];//如果不初始化dp[0]，那就存数组的时候从1开始
        if (number == 1) {  //如果数组下标从1开始，那么这里1的情况就要单独加进去
            return 1;
        }
        dp[0] = 1;//到第一个台阶
        dp[1] = 2;//到第二个台阶
        for (int i = 2; i < number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number-1];
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
