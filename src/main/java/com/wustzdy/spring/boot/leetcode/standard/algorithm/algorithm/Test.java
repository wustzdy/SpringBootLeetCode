package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//"s'teL ekat edoCteeL tsetnoc" 
public class Test {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String resultStr1 = transferStr1(str);
        System.out.println("resultStr1: " + resultStr1);


        String resultStr2 = transferStr2(str);
        System.out.println("resultStr2: " + resultStr2);


        int[] arr = {3, 2, 2, 3};
        int var = 3;
        int[] result = removeElement1(arr, var);
        for (int r : result) {
            System.out.println("result: " + r);
        }

    }

    private static int[] removeElement1(int[] arr, int var) {
        int[] result = null;
        int i = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] != var) {
                result[i] = arr[j];
                i++;
            }
            result = new int[i];
        }
        return result;
    }

    private static String transferStr2(String str) {
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(new StringBuilder(strings[i]).toString() + " ");
        }
        return stringBuilder.toString();
    }


    private static String transferStr1(String str) {
        String[] strings = str.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(new StringBuilder(strings[i]).reverse().toString() + " ");
        }
        return stringBuilder.toString();
    }
}
