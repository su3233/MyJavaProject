package com.oneline.java_concurrency.product_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockProConTest {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    private int queueSize = 10;
    private int[] items = new int[queueSize];
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public void put(int x) throws InterruptedException {
        lock.lock();
        try {
            while (count == queueSize) {
                // 如果队列满，则等待
                notFull.await();
            }
            items[tail] = x;
            tail = (tail + 1) % queueSize;
            ++count;
            // 可能会唤醒在notEmpty条件上等待的线程
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                // 如果队列空，则等待
                notEmpty.await();
            }
            int x = items[head];
            head = (head + 1) % queueSize;
            --count;
            // 可能会唤醒在notFull条件上等待的线程
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockProConTest pc = new LockProConTest();

        // 生产者线程
        Runnable producer = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    pc.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 消费者线程
        Runnable consumer = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    int taken = pc.take();
                    System.out.println("Consumed: " + taken);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 启动线程
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}