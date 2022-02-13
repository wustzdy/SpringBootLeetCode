package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220213;

import java.util.ArrayList;
import java.util.List;

/**  27. 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Test_05_RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int var = 3;
        int num = removeElement(arr, var);
        System.out.println("num： " + num);

        removeElement1(arr, var);
    }

    private static void removeElement1(int[] arr, int var) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        System.out.println("去除重复后的list集合" + list);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0; //记录顺序表nums[]中不等于val的元素个数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {//遍历数组元素与给定值比较，若不相等则赋值给i，进行新的数组长度计算。
                nums[i] = nums[j];
                i++;//不等于val的元素个数加1
            }
        }
        return i; //顺序表nums[]长度为i　
    }
}
