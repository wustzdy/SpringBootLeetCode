package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.insert;
//搜索插入位置
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

/***
 输入: nums = [1,3,5,6], target = 5
 输出: 2

 输入: nums = [1,3,5,6], target = 2
 输出: 1

 输入: nums = [1,3,5,6], target = 7
 输出: 4

 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
 查找结束如果没有相等值则返回 left，该值为插入位置

 作者：画手大鹏
 链接：https://leetcode.cn/problems/search-insert-position/solutions/8017/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class searchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        int result = searchInsert(nums, target);
        System.out.print("result:" + result);

    }

    /**
     * 初始化指针：设置两个指针 left 和 right 分别指向数组的开始和结束位置。
     * 二分搜索：计算中点 mid 并比较 nums[mid] 和 target：
     * <p>
     * 如果 nums[mid] 等于 target，直接返回 mid 作为答案。
     * 如果 nums[mid] 大于 target，调整 right 指针到 mid - 1，因为目标值在左半边。
     * 如果 nums[mid] 小于 target，调整 left 指针到 mid + 1，因为目标值在右半边。
     * <p>
     * 找到插入位置：如果循环结束还没有找到目标值，left 指针将指向应该插入目标值的位置。
     * 因为循环终止时，left 是第一个大于 target 的位置的索引。
     */
    public static int searchInsert(int[] nums, int target) {
        //         0  1  2  3
        //nums[i]: 1, 3, 5, 6
        // target =7
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
//            mid = left +(right-left)/2;//一回事
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;// right
            } else {
                left = mid + 1; // 在右半区继续查找
            }
        }
        return left;
    }
}
