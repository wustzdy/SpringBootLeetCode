package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.others;

//最长连续序列
/*示例 1：
    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

    示例 2：
    输入：nums = [0,3,7,2,5,8,4,6,0,1]
    输出：9
*/

import java.util.*;

// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
public class longestConsecutive {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
//        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        int[] nums = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        int result = longestConsecutive1(nums);
        System.out.println("result:" + result);
    }

    public static int longestConsecutive(int[] nums) {
        //100, 4, 200, 1, 3, 2
        //1,2,3,4,100,200
        //1,2,3,4,1,2
//        Arrays.sort(nums);
        // 使用HashSet去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 将Set转换为List以进行排序
        List<Integer> list = new ArrayList<>(set);

        // 使用Collections.sort对列表进行排序
        Collections.sort(list);
        nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        int maxLength = 1; // 记录最大的连续递增子序列的长度
        int currentLength = 1; // 记录当前连续递增子序列的长度

        // 遍历数组，从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && nums[i] - 1 == nums[i - 1]) {
                // 如果当前元素比前一个元素大，继续增加当前子序列的长度
                currentLength++;
            }
        }
        // 最后再比较一次，确保最后一组连续递增子序列被考虑到
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    //https://baijiahao.baidu.com/s?id=1764759781447590028&wfr=spider&for=pc
    //[case1]如果nums[i]+1在set中存在，则表示nums[i]不是连续序列的最大值，那么我们继续向下遍历，不用做任何操作；
//[case2]如果nums[i]+1在set中不存在，则表示nums[i]是连续序列的最大值，那么我们执行倒序查找set中的元素，
// 即：依次寻找nums[i]--的元素，并进行计数操作。
    public static int longestConsecutive1(int[] nums) {
        //100, 4, 200, 1, 3, 2
        int result = 0;
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        //set: 1 2 3 4 100 200
        //nums: 100, 4, 200, 1, 3, 2
        for (int num : nums) {
            if (!set.contains(num + 1)) {
                int max = 0;
                while (set.contains(num)) {
                    max++;
                    num--;
                }
                result = Math.max(result, max);
            }
        }
        return result;
    }

}
