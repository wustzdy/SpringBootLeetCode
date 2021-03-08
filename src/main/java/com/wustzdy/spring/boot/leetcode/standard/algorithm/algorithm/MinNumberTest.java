package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

//https://charming.blog.csdn.net/article/details/49363623?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control
/*题目：

    给定一个无序整型数组arr，找到数组中未出现的最小正整数。要求时间复杂度为O(N)空间复杂度为O(1)。

    例如：
    arr=[-1,2,3,4]。返回1。
    arr=[1,2,3,4]。返回5。*/
//找出数组中未出现的最小整数
/*思路分析：
我们可以考虑开一个数组B，用来统计，对于原来数组的为0的，小于0的，或者A[i]大于n的通通忽略，因为最小整数的范围是【1，n+1】，
我们只需要将符合的数在B数组钟置于1，即B[a[i]-1]=1,然后对B数组进行遍历，找到第一个为0的元素的下标+1即返回最小整数，否则返回n+1*/
public class MinNumberTest {
    public static void main(String[] args) {
        int[] arr = {-5, 3, 2, 3};
        int the_diasppar_min_number = find_the_appear_min_number(arr);
        System.out.println("the_diasppar_min_number: " + the_diasppar_min_number);

        System.out.println("missNum: " + missNum(arr));

    }

    public static int find_the_appear_min_number(int[] arr) {
        int i;
        int length = arr.length;
        int[] B = new int[length];
        for (i = 0; i < length; i++) {
            if (arr[i] > 0 && arr[i] <= length) {
                B[arr[i] - 1] = 1;
            }
        }
        for (i = 0; i < length; i++) {
            if (B[i] == 0) {
                break;
            }
        }
        return i + 1;
    }
//[-1,2,3,4]。返回1。
    public static int missNum(int[] arr) {
        int l = 0; //l表示已经从1到L已经出现（左边界），l的初值为0。
        int r = arr.length; //如果一个数字过大（不合法），就会被扔掉，用r表示这个右边界，r初始值为arr长度。
        int temp;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l]) {//不合法
                arr[l] = arr[--r];
            } else {//合法但是没有在理想的位置上
                temp = arr[l];
                arr[l] = arr[arr[l] - 1];
                arr[temp - 1] = temp;
            }
        }
        return l + 1;
    }

}
/*
算法总结之 数组中未出现的最小正整数
给定一个无序整型数组arr，找到数组中未出现的最小正整数

解题思路非常好，需要好好学习一下，很逻辑

如果arr长度为N， 最优解可以做到时间复杂度O（N） 额外空间复杂度O(1)

1、遍历arr之前生成两个变量， l  r   初始值 l=0   r=N

2、从左到右遍历arr，arr[l]

3、如果arr[l]=l+1 没有遍历arr[l]之前，arr已经包含的正整数范围是[1,l]，此时出现了arr[l]=l+1的情况，所以arr包含的正整数范围可以扩展到[1,l+1]  即令 l++

4、如果arr[l]<=l  没有遍历arr[l]之前，arr在后续最优的情况下可能包含的正整数范围是[l,r],已经包含了的正整数的范围是[1,l],所以需要[l+1,r]上的数。而此时出现了arr[l]<=l,说明[l+1,r]范围上的数少了一个，所以

arr在后续最优的情况下，可能包含的正整数范围缩小了，变为[l,r-1],此时把arr最后位置的数（arr[r-1]）放在位置l上，下一步检查这个数，然后令r--,

5、如果arr[l]>r,与上面同理的，把arr最后位置的数（arr[r-1]）放在位置l上，下一步检查这个数，然后令r--

6、如果arr[l]=arr[arr[i]-1],如果上面两个都没中，说明 arr[l]是在[l+1,r]范围上的数，而且这个数应该放在arr[l]-1位置上，可是此时发现arr[l]-1位置上的数已经是arr[l], 说明出现了两个arr[l]呀，既然在[l+1,r]上出现了         两个arr[l],重复了。那么[l+1,r]范围上的数又少了一个，所以与步骤4和5一样，把arr[r-1]放在位置l上，下一步检查，然后另r--

7、 如果都没有中，说明发现了[l+1,r]范围上的数，并且没有重复。那么arr[l]应该放在arr[l]-1位置上，所以把l位置上的数和arr[l]-1位置上的数交换，下一步继续遍历l位置上的数



        最终l和r会碰撞在一起（l==r） arr已经包含的正整数范围是[1,l],*/
