package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.io.InputStream;
import java.util.Scanner;

//爬楼梯
public class climbStairs {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int sum = getClimbStairsLayer(num);
            System.out.println("一共有  " + sum);
        }
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
