package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//斐波拉契额数列
public class tribonacci {
    public static void main(String[] args) {
        int result = Fibonacci(10);
        System.out.println("result:" + result);


//        generateFibonacci(5);

    }

    public static int dynamicInt(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    //0,1,1,2,3,5
    public static int Fibonacci(int n) {
        // write code here
        if (n <= 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //0,1,1,2,3,5
    public static int dynamicInt2(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    public static void generateFibonacci(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }

    //1137. 第 N 个泰波那契数
    //泰波那契序列 Tn 定义如下：
    //T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
    //给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
  /*  示例 1：
    输入：n = 4
    输出：4
    解释：
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4
   */ //0,1,1,2,3,5
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        return nums[n];
    }

    //0,1,1,2,3,5
}
