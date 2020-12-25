package com.oneline.sort;

import java.util.Arrays;

/**
 * 快速排序，效率较高
 * 空间复杂度：O（log n）
 * 时间复杂度:O(n log(n))
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arrays = {2, 4, 3, 1, 9, 8, 6, 7, 5};
        quickSort(arrays);
        System.out.println(Arrays.toString(arrays));
//        Arrays.stream(arrays).forEach(System.out::println);
    }

    private static void quickSort(int[] arrs, int left, int right) {
        //设置排序结束的条件
        if (left > right) {
            return;
        }
        //记录左边的编号，记录右边的编号
        int i = left, j = right;
        //记录基准数字
        int base = arrs[left];

        //核心算法
        while (i != j) {
            //右侧编号查找数字比base小的
            while (j > i && arrs[j] >= base) {
                j--;
            }
            //左侧编号查找数字比base大的
            while (j > i && arrs[i] <= base) {
                i++;
            }
            //数字交换
            if (j > i) {
                int temp = arrs[j];
                arrs[j] = arrs[i];
                arrs[i] = temp;
            }
        }
        //基准数字和i位置数字的交换,i位置成为基准数字
        arrs[left] = arrs[i];
        arrs[i] = base;
        //左侧数字进行二次分类
        quickSort(arrs, left, i - 1);
        //右侧数字进行二次分类
        quickSort(arrs, i + 1, right);
    }

    private static void quickSort(int[] arrs) {
        quickSort(arrs, 0, arrs.length - 1);
    }
}
