package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//26. 删除排序数组中的重复项
// ava双指针
// 如果数组长度为0直接返回0结束
// 定义一个变量充当指针
// 循环数组 在定义一个指针标记数组数据
// 如果第一个数等于第二个数不往下执行 继续执行for循环j+1，i不变，
// 如果索引为i的数不等于索引为j的数往下执行，i+i，并且把索引为j的数赋值给所因为i的数，在找是否有和所因为i的数不同的数然后i在+1，知道遍历完数组中的所有数返回i+1。
// 代码
public class RemoveDuplicateTest {
    public static void main(String[] args) {
        int[] array = {1, 1, 2};
        int num = removeDuplicates(array);
        System.out.println("num= " + num);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0; //指针
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
