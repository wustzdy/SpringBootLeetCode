package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.test;

public class test {
    public static int[] findDoubleInt(int[] arr) {

        int i = 0;
        while (arr[i]==0) {
            i++;
        }
        int start = arr[i];
        arr[i] = -1;
        while (i<arr.length) {

            start = (start + arr[start-1]) - (arr[start-1] = start);
            if (start == 0 ||start == -1) {
                i = 0;
                while (arr[i] == 0 || arr[i] == -1 || arr[i] == i+1) {
                    i++;
                    if (i == arr.length-1) {
                        break;
                    }
                }
                if (i == arr.length-1) {
                    break;
                }
                start = arr[i];
                arr[i] = -1;
            }else {
                i++;
            }

        }
        int[] result = new int[2];
        i = 0;
        for (int j = 0; j < arr.length; j++) {

            if(arr[j] <= 0) {
                result[i++] = j+1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0,3,5,8,6,4,1,9,7,0}; // 2 10

        int[] result = findDoubleInt(a);
        System.out.println(result[0] + "," + result[1]);
    }
}
