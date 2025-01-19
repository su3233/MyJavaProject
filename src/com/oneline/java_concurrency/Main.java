package com.oneline.java_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /**
         * 执行顺序（静态代码块-静态方法）
         */
//        InitTest.staticMethod();


        /**
         * 执行顺序（静态代码块-构造函数-静态方法）
         */
//        new InitTest().staticMethod();

//        new InitTest().normalMethod();

        /**
         * 线程的使用
         */
        new Thread(new ThreadProfiler()).start();
    }

    static class ThreadProfiler implements Runnable {
        private AtomicInteger num = new AtomicInteger();

        @Override
        public void run() {
            while (num.get() != 30) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("num:" + num.getAndIncrement());
            }
        }
    }
}