package com.oneline.java_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        runThread();
    }

    private static void runThread() {
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyThread());

        }
        executorService.shutdown();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+".."+Thread.currentThread().getId());

        }
    }
}
