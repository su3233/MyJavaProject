package com.oneline.java_concurrency.product_consumer.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumerExample {
    private final List<Integer> buffer = new ArrayList<>();
    private static final int MAX_BUFFER_SIZE = 5;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            while (buffer.size() == MAX_BUFFER_SIZE) {
                System.out.println("缓冲区已满，生产者等待...");
                notFull.await();
            }
            int data = (int) (Math.random() * 100);
            buffer.add(data);
            System.out.println("生产者生产数据: " + data + "，当前缓冲区大小: " + buffer.size());
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                System.out.println("缓冲区为空，消费者等待...");
                notEmpty.await();
            }
            int data = buffer.remove(0);
            System.out.println("消费者消费数据: " + data + "，当前缓冲区大小: " + buffer.size());
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.produce();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.consume();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("程序结束");
    }
}
