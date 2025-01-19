package com.oneline.java_concurrency.product_consumer;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        // 创建一个对象
        Object obj = new Object();

        // 创建一个 PhantomReference，并将其与引用队列关联
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, referenceQueue);

        // 清除强引用，使对象变得只有 PhantomReference 引用
        obj = null;

        // 提醒垃圾回收器进行回收
//        System.gc();

        // 检查引用队列，看是否有对象被回收
        Thread.sleep(1000); // 等待一段时间，确保垃圾回收完成
        if (referenceQueue.poll() != null) {
            System.out.println("对象已被垃圾回收");
        } else {
            System.out.println("对象未被垃圾回收");
        }
    }
}
