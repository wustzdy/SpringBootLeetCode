package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//找出数组中未出现的最小整数
/*思路分析：
我们可以考虑开一个数组B，用来统计，对于原来数组的为0的，小于0的，或者A[i]大于n的通通忽略，因为最小整数的范围是【1，n+1】，
我们只需要将符合的数在B数组钟置于1，即B[a[i]-1]=1,然后对B数组进行遍历，找到第一个为0的元素的下标+1即返回最小整数，否则返回n+1*/
public class MinNumberTest {
    public static void main(String[] args) {
        int[] arr = {-5, 3, 2, 3};
        int the_diasppar_min_number = find_the_appear_min_number(arr);
        System.out.println("the_diasppar_min_number: " + the_diasppar_min_number);

    }

    public static int find_the_appear_min_number(int[] arr) {
        int i;
        int length = arr.length;
        int[] B = new int[length];
        for (i = 0; i < length; i++) {
            if (arr[i] > 0 && arr[i] <= length) {
                B[arr[i] - 1] = 1;
            }
        }
        for (i = 0; i < length; i++) {
            if (B[i] == 0) {
                break;
            }
        }
        return i + 1;
    }
}
