package com.oneline.java_concurrency.product_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProductConsumerThread {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(3);

        class ProductThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    int proInt = (int) (Math.random() * 100);
                    try {
                        blockingQueue.put("" + proInt);
//                        blockingQueue.offer("" + proInt);
                        Thread.sleep(1000);
                        System.out.println("生产：" + proInt);
//                        System.out.println("生产：......." + blockingQueue.size());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
//                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        class ConsumerThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    try {
                        String conInt = blockingQueue.take();
//                        String conInt = blockingQueue.poll();
                        System.out.println("消费：" + conInt);
//                        System.out.println("消费：......." + blockingQueue.size());

                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
//                        Thread.currentThread().interrupt();

                    }
                }
            }
        }
        new ProductThread().start();
        new ConsumerThread().start();

    }

}

