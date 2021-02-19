package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.io.InputStream;
import java.util.Scanner;

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
