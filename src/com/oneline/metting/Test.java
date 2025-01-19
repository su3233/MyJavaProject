package com.oneline.metting;

/**
 * 小白羽
 * 判断是否是回文数 1221
 * 2024.11 09:05
 */
public class Test {
    public static void main(String[] args) {
        //121、1221、2332
        boolean result = hui(123454321);
        System.out.println("result:" + result);
    }

    private static boolean hui(int num) {
        boolean result = false;
        String numStr = num + "";
        int part = numStr.length() / 2;
        for (int i = 0; i < part; i++) {
            char front = numStr.charAt(i);
            char nail = numStr.charAt(numStr.length() - 1 - i);
            result = front == nail;
        }

//        if (part / 2 == 0) {
//            String front = numStr.substring(0, part);
//            System.out.println("front1:" + front);
//            String nail = numStr.substring(part, numStr.length());
//            System.out.println("nail1:" + nail);
//        } else {
//            String front = numStr.substring(0, part);
//            System.out.println("front2:" + front);
//            String nail = numStr.substring(part, numStr.length());
//            System.out.println("nail2:" + nail);
//        }

        return result;
    }

}
