package com.oneline.java_concurrency.product_consumer;

import java.util.Random;

public class JoinTest {
    public static void main(String[] args) {
//        join_1();
        join_2();
    }

    private static void join_2() {
        System.out.println(Thread.currentThread().getName() + " start");
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");

        System.out.println("t1 start");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("t1 end");

        System.out.println("t2 start");
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("t2 end");
        System.out.println(Thread.currentThread().getName() + " end");
    }

    static class ThreadTest extends Thread {
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(name + "-" + i);
                try {
                    Thread.sleep(new Random().nextInt(10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void join_1() {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running.");
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println("Thread 2 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                System.out.println("Thread 3 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
