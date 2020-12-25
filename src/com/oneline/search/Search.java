package com.oneline.search;

/**
 *
 */
public class Search {
    public static void main(String[] args) {

    }

    /**
     * 顺序查找
     *
     * @param a   数据源
     * @param key 要查找的元素
     * @return
     */
    public static int search(int[] a, int key) {
        for (int i = 0, length = a.length; i < length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    /**
     * 二分法查找
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (value == array[middle]) {
                return middle;
            }
            if (value > array[middle]) {
                low = middle + 1;
            }
            if (value < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 使用递归
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch4(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        return searchmy(array, low, high, value);
    }

    private static int searchmy(int array[], int low, int high, int value) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) >> 1);
        if (value == array[mid])
            return mid;
        if (value < array[mid])
            return searchmy(array, low, mid - 1, value);
        return searchmy(array, mid + 1, high, value);
    }
}
