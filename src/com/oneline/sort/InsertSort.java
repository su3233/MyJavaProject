package com.oneline.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] dataArray = {5, 3, 1, 8, 7, 6, 4, 9, 2};
        insertSortMethod(dataArray);
        Arrays.stream(dataArray).forEach(System.out::println);
    }

    private static void insertSortMethod(int[] arrs) {
        //1、循环购买玩具，模拟玩具的增加过程
        for (int i = 0; i < arrs.length; i++) {
            System.out.println("i---"+i);
            //2、对自己的已有玩具进行排序
            for (int j = i-1; j >=0; j--) {
                System.out.println("j---"+j);
                //3、交换数据
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                }
            }
            System.out.println("-------------------------");
        }
    }
}
