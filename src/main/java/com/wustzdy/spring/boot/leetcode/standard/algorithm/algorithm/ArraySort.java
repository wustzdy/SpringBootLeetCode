package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.util.Arrays;
//1470. 重新排列数组
/*给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
        请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shuffle-the-array*/
/*示例 1：

        输入：nums = [2,5,1,3,4,7], n = 3
        输出：[2,3,5,4,1,7]
        解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
        示例 2：

        输入：nums = [1,2,3,4,4,3,2,1], n = 4
        输出：[1,4,2,3,3,2,4,1]
        示例 3：

        输入：nums = [1,1,2,2], n = 2
        输出：[1,2,1,2]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shuffle-the-array*/
/*思路如下：
        1：数组分成两部分看x1,x2,...,xn；y1,y2,...,yn，也就是说x1下标为i，那么y1的下标为n+i；
        2：最终排序后x1,y1,x2,y2,...,xn,yn；也就是说我们要把x1,x2,...,xn放到数组的下标为偶数的位置，y1,y2,...,yn则放到数组的下标为奇数的地方
        3：接下来就简单了，新数组的偶数下标位置放x，奇数下标位置放y
        链接：https://leetcode-cn.com/problems/shuffle-the-array/solution/yi-ge-xun-huan-100-71-by-zheng-rong-huai-k46q/*/
public class ArraySort {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] result = arraySort(array, 4);

        //循环字符串类型的数组
//        Arrays.asList(result).stream().forEach(x -> System.out.print(x));
//        Arrays.asList(result).stream().forEach(System.out::println);

        //循环int类型的数组
        Arrays.stream(result).forEach(x -> System.out.print(x + "，"));
        Arrays.stream(result).forEach(System.out::print);


    }

    private static int[] arraySort(int[] array, int n) {
        int[] resultArray = new int[2 * n];
        for (int i = 0; i < n; i++) {
            //偶数下标放X
            resultArray[2 * i] = array[i];
            //奇数下标放y
            resultArray[2 * i + 1] = array[n + i];
        }
        return resultArray;
    }
}
