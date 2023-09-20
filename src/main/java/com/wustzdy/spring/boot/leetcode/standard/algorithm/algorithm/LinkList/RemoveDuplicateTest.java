package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

import static jdk.nashorn.internal.objects.Global.print;

//26. 删除排序数组中的重复项
// ava双指针
// 如果数组长度为0直接返回0结束
// 定义一个变量充当指针
// 循环数组 在定义一个指针标记数组数据
// 如果第一个数等于第二个数不往下执行 继续执行for循环j+1，i不变，
// 如果索引为i的数不等于索引为j的数往下执行，i+i，并且把索引为j的数赋值给所因为i的数，在找是否有和所因为i的数不同的数然后i在+1，知道遍历完数组中的所有数返回i+1。
// 代码
// //https://www.jianshu.com/p/da38b14b0a67
public class RemoveDuplicateTest {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates2(nums);
        System.out.println("len:" + len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
       /* for (int i = 0; i < len; i++) {
            print(nums[i]);
        }*/
        for (int i : nums) {
            System.out.println(i + ",");
        }
    }

    public static int removeDuplicates(int[] nums) {
        //1 1 2
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
    public static int removeDuplicates2(int[] nums) {
        //1 1 2
        if (nums.length == 0) {
            return 0;
        }
        int i = 0; //指针
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
