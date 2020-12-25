package com.oneline.sort;

import java.util.Arrays;

/**
 * 冒泡排序：每相邻两个元素进行比较，小的元素放在前面，比较过的元素不再比较
 */
public class BubbleTest {
    public static void main(String[] args) {
        int[] arrays = {2, 5, 4, 9, 3, 7, 1, 8};
        bubbleSort(arrays);
        Arrays.stream(arrays).forEach(System.out::println);
    }

    public static void bubbleSort(int[] arrs) {
        //1、包含所有参与游戏的人物
        for (int i = arrs.length - 1; i > 0; i--) {
            //2、控制交换手绢的国过程
            for (int j = 0; j < i; j++) {
                //3、设置交换手绢的条件
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }
    }

}
