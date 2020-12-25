package com.oneline.sort;

import java.util.Arrays;

/**
 * 选择排序：默认选择第一个为最小元素，然后依次和后续元素比较，有比自己小的就记录角标，比完一轮真实交换
 * 已比较的元素不再参与下次比较
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arrays = {2, 4, 3, 1, 9, 8, 6, 7, 5};
        selectSort(arrays);
        Arrays.stream(arrays).forEach(System.out::println);
    }

    private static void selectSort(int[] arrs) {
        //1、循环所有参与游戏的小伙伴
        for (int i = 0; i < arrs.length ; i++) {
            //2、假设当前第一个元素为最小
            int minIndex = i;
            //3、当前最小元素和其他元素对比
            for (int j = i; j < arrs.length ; j++) {
                //默认首个最小，如果有比他小的，先记录角标
                if (arrs[j] < arrs[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arrs[i];
                arrs[i] = arrs[minIndex];
                arrs[minIndex] = temp;
            }
        }
    }
}
