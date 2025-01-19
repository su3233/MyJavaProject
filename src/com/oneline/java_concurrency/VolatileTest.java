package com.oneline.java_concurrency;

public class VolatileTest {
    private static volatile int num = 0;
    private static volatile boolean end = false;

    public static void main(String[] args) {
        int nn = 0;
        System.out.println("test ++：" + nn++);
        nn++;
        System.out.println("test ++：" + nn);
        test();
    }

    private static void test() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                num++;
                System.out.println("thread ++" + num);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            end = true;

        }).start();

        new Thread(() -> {
            while (!end) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("num:" + num);
            }

        }).start();
    }
}
