package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100;

//https://leetcode.cn/problems/container-with-most-water/solutions/11491/container-with-most-water-shuang-zhi-zhen-fa-yi-do/?envType=study-plan-v2&envId=top-100-liked// LeetCode第11题 盛最多水的容器
public class maxArea {
    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxarea = maxArea2(heights);
        System.out.println("maxarea:" + maxarea);
    }

    //第一种
    public static int maxArea1(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    //第二种
    //[1,8,6,2,5,4,8,3,7]
    //s(0,8)=min(1,7)*(8-0)=8;
    // res =max(res,s(0,8))=8
    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
    //https://leetcode.cn/problems/container-with-most-water/solutions/11491/container-with-most-water-shuang-zhi-zhen-fa-yi-do/

    public static int maxArea3(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea,(j - i) * height[i]);
                i++;
            } else {
                maxArea = Math.max(maxArea,(j - i) * height[j]);
                j--;
            }
        }
        return maxArea;

    }
}
