package com.oneline.test;

public class Test {
    public static void main(String[] args) {
//        testStringEqual();

//        int value = testFebonaci(7);
//        System.out.println(value);
        //测试继承关系是父类方法先执行还是子类方法先执行-
        new RawClass().getName();
    }

    /**
     * 测试返回斐波那契数列第n个的值
     *
     * @param i 第几个元素，默认从第一个开始
     */
    private static int testFebonaci(int i) {
        int pre = 1;
        int after = 1;
        int sum = 2;
        if (i < 0)
            return 0;
        //第1个和第二个位置值为1
        if (i == 1 || i == 2)
            return 1;
        for (int n = 3; n <= i; n++) {
            sum = pre + after;
            pre = after;
            after = sum;
        }
        return sum;
    }

    /**
     * 判断字符串是否相等
     */
    private static void testStringEqual() {
        String str = "kill";
        String str_1 = "kill";
        String str_2 = "ki" + new String("ll");
        String str_3 = "ki" + "ll";
        String str_4 = "ki";
        String str_5 = "ll";

        System.out.println(str == str_1);//true
        System.out.println(str == str_2);//false
        System.out.println(str == str_3);//true
        System.out.println(str == str_4 + str_5);//false
    }


}
