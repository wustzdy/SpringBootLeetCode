package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.sort;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 1, 3, 8};
        quickSort1(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.println(" "+i);
        }
    }

    private static void quickSort1(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort1(arr, low, index - 1);
            quickSort1(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high]>=temp) {
                high--;
            }
            arr[low]=arr[high];

            while (low < high && arr[low]<=temp) {
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }


}
