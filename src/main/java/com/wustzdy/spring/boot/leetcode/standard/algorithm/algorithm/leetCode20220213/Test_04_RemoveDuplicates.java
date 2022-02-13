package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220213;

//26. 删除排序数组中的重复项
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 **/
/*解题思路：
        解法： 双指针
        首先注意数组是有序的，那么重复的元素一定会相邻。
        要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
        考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
        1.比较 p 和 q 位置的元素是否相等。
        如果相等，q 后移 1 位
        如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
        重复上述过程，直到 q 等于数组长度。
        返回 p + 1，即为新数组长度*/
//不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

// ava双指针
// 如果数组长度为0直接返回0结束
// 定义一个变量充当指针
// 循环数组 在定义一个指针标记数组数据
// 如果第一个数等于第二个数不往下执行 继续执行for循环j+1，i不变，
// 如果索引为i的数不等于索引为j的数往下执行，i+i，并且把索引为j的数赋值给所因为i的数，在找是否有和所因为i的数不同的数然后i在+1，知道遍历完数组中的所有数返回i+1。
public class Test_04_RemoveDuplicates {
    public static void main(String[] args) {

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
