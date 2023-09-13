package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

public class MethodParamsPassValue {
    public static void passBaseValue(boolean flg, int num) {
        flg = true;
        num = 10;
        System.out.println("flg : " + flg + " num: " + num);
    }

    public static void main(String[] args) {
        boolean a = false;
        int b = 5;
        System.out.println("a : " + a + " b : " + b);
        passBaseValue(a, b);
        System.out.println("a : " + a + " b : " + b);
    }
}
