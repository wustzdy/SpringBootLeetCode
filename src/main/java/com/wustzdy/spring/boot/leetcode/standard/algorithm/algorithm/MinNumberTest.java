package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

//https://charming.blog.csdn.net/article/details/49363623?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control
/*题目：

    给定一个无序整型数组arr，找到数组中未出现的最小正整数。要求时间复杂度为O(N)空间复杂度为O(1)。

    例如：
    arr=[-1,2,3,4]。返回1。
    arr=[1,2,3,4]。返回5。*/
//找出数组中未出现的最小整数
/*思路分析：
我们可以考虑开一个数组B，用来统计，对于原来数组的为0的，小于0的，或者A[i]大于n的通通忽略，因为最小整数的范围是【1，n+1】，
我们只需要将符合的数在B数组钟置于1，即B[a[i]-1]=1,然后对B数组进行遍历，找到第一个为0的元素的下标+1即返回最小整数，否则返回n+1*/
public class MinNumberTest {
    public static void main(String[] args) {
        int[] arr = {-5, 3, 2, 3};
        int the_diasppar_min_number = find_the_appear_min_number(arr);
        System.out.println("the_diasppar_min_number: " + the_diasppar_min_number);

        System.out.println("missNum: " + missNum(arr));

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

    public static int missNum(int[] arr) {
        int l = 0; //l表示已经从1到L已经出现（左边界），l的初值为0。
        int r = arr.length; //如果一个数字过大（不合法），就会被扔掉，用r表示这个右边界，r初始值为arr长度。
        int temp;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l]) {//不合法
                arr[l] = arr[--r];
            } else {//合法但是没有在理想的位置上
                temp = arr[l];
                arr[l] = arr[arr[l] - 1];
                arr[temp - 1] = temp;
            }
        }
        return l + 1;
    }

}