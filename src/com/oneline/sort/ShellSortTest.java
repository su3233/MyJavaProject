package com.oneline.sort;

import java.util.Arrays;

/**
 * 希尔排序：
 */
public class ShellSortTest {
    public static void main(String[] args) {
        int[] arrays = {5, 1, 3, 4, 9, 6, 2, 8, 7};
        shellSort(arrays);
        Arrays.stream(arrays).forEach(System.out::println);
    }

    private static void shellSort(int[] arrs) {
//1、先得到小组
        int gap = arrs.length / 2;
        //声明一个变量，记录当前数据
        int current;
        //2、循环遍历所有小组
        while (gap > 0) {
            //3、对当前小组中的数据进行遍历操作
            for (int i = gap; i < arrs.length; i++) {
                current = arrs[i];//当前需要比较的数据
                int preIndex = i - gap;//得到小组内上一个数据的索引
                System.out.println("preIndex..." + preIndex);
                //4、内部数据进行插入排序
                while (preIndex >= 0 && current < arrs[preIndex]) {
                    //数据交换
//                    arrs[preIndex + gap] = arrs[preIndex];
                    arrs[i] = arrs[preIndex];
                    preIndex -= gap;
                    System.out.println("preIndex====" + preIndex);
                }
                arrs[preIndex + gap] = current;
                System.out.println("------------------------");
            }
            gap = gap / 2;
        }
    }
}
