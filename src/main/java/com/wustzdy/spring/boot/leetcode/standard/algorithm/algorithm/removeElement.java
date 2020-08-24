package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

/**
 * 移出元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class removeElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int var = 3;
        int num = removeElement(arr, var);
        System.out.print("num： " + num);
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
