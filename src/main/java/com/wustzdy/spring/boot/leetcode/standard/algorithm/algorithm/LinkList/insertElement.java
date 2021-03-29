package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

/*1.设顺序表用数组A[]表示，表中元素存储在数组下标1~m+n的范围内，前m个元素递增有序，后n个元素也递增有序，设计一个算法，使得整个顺序表有序。
        (1) 给出算法的基本设计思想。
        (2) 根据设计思想，采用C或C++语言描述算法，并在关键之处给出注释。
        (3) 说明你所设计的算法的时间复杂度和空间复杂度。*/
public class insertElement {
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 2, 5};
        insetElement(A, 3, 2);

        for (int element : A) {
            System.out.print(" " + element);
        }

    }

    public static void insetElement(int[] A, int m, int n) {
        int i, j;
        int temp;
        for (i = m; i < m + n; ++i) {
            temp = A[i];
            for (j = i - 1; j >= 0 && temp < A[j]; --j) {
                A[j + 1] = A[j];
            }
            A[j + 1] = temp;
        }
    }
}
