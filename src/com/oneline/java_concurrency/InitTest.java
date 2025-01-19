package com.oneline.java_concurrency;

public class InitTest {
    public static final int num = 0;

    public InitTest() {
        System.out.println("构造函数");

    }

    static {
        System.out.println("静态代码块");
    }

    public static void staticMethod() {
        System.out.println("静态方法");
    }

    public void normalMethod(){
        System.out.println("普通方法");
    }

}
