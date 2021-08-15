package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.StringAndArray;

//王道课后习题2.2.10:将R中的序列循环左移P个位置
//设将n(n>1)个整数存放到一维数组R中。设计一个在时间和空间两方面尽可能高效的算法。
// 将R中的序列循环左移P（0<P<n）个位置，即将R中的数据由（x0，x1，…，xn-1）变换为（xp，Xp+1，…，Xn-1，x0，x1，…，Xp-1）。要求：
//输入：0, 1, 2, 3, 4, 5, 6, 7, 8, 9
//输出：5 6 7 8 9 0 1 2 3 4
//https://blog.csdn.net/weixin_42426690/article/details/94486310?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242
/*2020王道P18，综合10：将一维数组A中的数列循环左移P个位置。个人感觉这一题与第八题很相似，先说说思路：
        例如数组：{1,2,3,4,5,6,7,8,9}
        1.将前P个数逆置。----->{4,3,2,1,5,6,7,8,9}
        2.将后n-p个数逆置。----->{4,3,2,1,9,8,7,6,5}
        3.将整个数组逆置。----->{5,6,7,8,9,1,2,3,4}*/
public class StringLeftRetote {
    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int p = 5;
        int n = 10;
        Reverse(0, p - 1, array);////逆置前P个
        Reverse(p, n - 1, array);//逆置后n-p个
        Reverse(0, n - 1, array);//逆置整个数组

        for (int i : array) {
            System.out.print(i + ",");
        }
    }

    private static void Reverse(int left, int right, int A[]) {
        if (left >= right || right >= A.length)
            return;
        int mid = (left + right) / 2;
        for (int i = 0; i <= mid - left; i++) {
            int temp = A[left + i];
            A[left + i] = A[right - i];
            A[right - i] = temp;
        }
    }
}
