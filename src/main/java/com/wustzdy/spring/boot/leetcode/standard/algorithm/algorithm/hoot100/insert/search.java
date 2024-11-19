package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.insert;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;

/**
 * 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/22068/ji-bai-liao-9983de-javayong-hu-by-reedfan/?envType=study-plan-v2&envId=top-100-liked
 */
public class search {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);
        System.out.print("result:" + result);

    }

    public static int search(int[] nums, int target) {
        //下标：    0 1 2 3 4 5 6
        //nums[i]: 4,5,6,7,0,1,2
        //target =0
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //后半部分有序
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    //standard
    //https://www.bilibili.com/video/BV1tz421r7xC/?spm_id_from=333.337.search-card.all.click&vd_source=5363405f0e14a0e8f06bcae41548f41e
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }

            ////[left, mid]是有序数组，[mid+1, right]是旋转数组
            if (nums[left] <= nums[mid]) {//第一个递增区间
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//[left, mid-1]是旋转数组，[mid, right]是有序数组 //第二个递增区间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
