package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.practise;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList.DeleteElement;

//删除最小的元素并用最后一个元素代替
public class DeleteMinElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        DeleteMin(array);
    }

    private static void DeleteMin(int[] array) {
        if (array.length == 0) {
            return;
        }
        int value = array[0];
        int pos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < value) {
                value = array[i];
                pos = i;
            }
        }
        System.out.println("pos:" + pos);
        array[pos] = array[array.length - 1];

        int[] temp = new int[array.length - 1];
        System.arraycopy(array, pos, temp, 0, temp.length);
        for (int ele : temp) {
            System.out.print(ele + ",");
        }
    }
}
