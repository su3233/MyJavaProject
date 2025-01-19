package com.oneline.java_concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        Future<String> future = ThreadPoolTest.executorService.submit(myCallable);
        String result = future.get();
        System.out.println(result);
        ThreadPoolTest.executorService.shutdown();
    }

    static class MyCallable implements Callable<String> {
        AtomicInteger atomicInteger = new AtomicInteger(0);


        @Override
        public String call() throws Exception {
            while (atomicInteger.get() <= 10) {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis());
                atomicInteger.getAndIncrement();
            }
            return "callable:" + atomicInteger.get();
        }
    }
}
