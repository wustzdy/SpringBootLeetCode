package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.commonArray;
//轮转数组：给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
/*
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
*/
//方法三：数组翻转
/*
该方法基于如下的事实：当我们将数组的元素向右移动 kkk 次后，尾部 k mod nk\bmod nkmodn 个元素会移动至数组头部，其余元素向后移动 k mod nk\bmod nkmodn 个位置。
该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k mod nk\bmod nkmodn 个元素就被移至数组头部，然后我们再翻转 [0,k mod n−1][0, k\bmod n-1][0,kmodn−1] 区间的元素和 [k mod n,n−1][k\bmod n, n-1][kmodn,n−1] 区间的元素即能得到最后的答案。
我们以 n=7n=7n=7，k=3k=3k=3 为例进行如下展示：
作者：力扣官方题解
链接：https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
/*
我们以 n=7，k=3 为例进行如下展示：
操作	结果
原始数组	1 2 3 4 5 6 7
翻转所有元素	7 6 5 4 3 2 1
翻转 [0,k mod n−1]区间的元素	5 6 7 4 3 2 1
翻转 [k mod n,n−1]区间的元素	5 6 7 1 2 3 4
*/
public class rotate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] rotate = rotate(nums, 3);
        for (int i : rotate) {
            System.out.print(i + ",");
        }
    }

    public static int[] rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
