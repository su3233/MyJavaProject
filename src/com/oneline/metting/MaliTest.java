package com.oneline.metting;

import java.util.ArrayList;
import java.util.List;

public class MaliTest {
    public static void main(String[] args) {
        int result = compareVersion("1.1.0", "1.0.0");
        System.out.println(result);

        int[] array = {4, 6, 7, 4, 2, 8, 3};
        int n = 14;
        List<Integer> resultList = findContinuousSubArray(array, n);
        System.out.println(resultList);
    }

    public static int compareVersion(String versionName, String targetVersionName) {
        String[] versionArr = versionName.split("\\.");
        String[] targetVersionArr = targetVersionName.split("\\.");
        int length = Math.max(versionArr.length, targetVersionArr.length);
        for (int i = 0; i < length; i++) {
            int v1 = i < versionArr.length ? Integer.parseInt(versionArr[i]) : 0;
            int v2 = i < targetVersionArr.length ? Integer.parseInt(targetVersionArr[i]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    public static List<Integer> findContinuousSubArray(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            List<Integer> subArray = new ArrayList();
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                subArray.add(array[j]);
                if (sum == n) {
                    return subArray;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return new ArrayList<>();
    }
//    public static List<Integer> findContinuousSubarray(int[] array, int n) {
//        for (int i = 0; i < array.length; i++) {
//            int sum = 0;
//            List<Integer> subarray = new ArrayList<>();
//            for (int j = i; j < array.length; j++) {
//                sum += array[j];
//                subarray.add(array[j]);
//                if (sum == n) {
//                    return subarray;
//                } else if (sum > n) {
//                    break;
//                }
//            }
//        }
//        return new ArrayList<>();
//    }

}
