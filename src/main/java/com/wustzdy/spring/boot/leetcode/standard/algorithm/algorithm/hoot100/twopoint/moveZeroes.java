package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.twopoint;

//定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
/*
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
*/
public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] ints = moveZeroes1(nums);
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }

    public static int[] moveZeroes(int[] nums) {
        if (nums == null) {
            return null;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        return nums;
    }

    public static int[] moveZeroes1(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
