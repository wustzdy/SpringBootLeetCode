package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.stack;

public class dailyTemperatures {
    public static void main(String[] args) {
//        int[] T = new int[]{30, 40, 50, 60};
        int[] T = new int[]{3, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures2(T);
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        //30,40,50,60
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 1000) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static int[] dailyTemperatures1(int[] T) {
        ////30,40,50,60
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] dailyTemperatures2(int[] T) {
        ////30,40,50,60
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            int j = i + 1;
            while (j < length) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
                j = j + result[j];
            }
        }
        return result;
    }
}
