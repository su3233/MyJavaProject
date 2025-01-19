package com.oneline.java_concurrency;

/**
 * 第三章：java内存模型
 */
public class ThreadTest {
    private ThreadTest() {
    }

    /**
     * 优化双重检查锁单例，禁止对象初始化和指向内存两步重排序
     */
    private volatile static ThreadTest instance;

    private static ThreadTest getInstance() {
        if (instance == null) {
            synchronized (ThreadTest.class) {
                if (instance == null) {
                    instance = new ThreadTest();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类方式创建单例，使重排序对其他线程不可见
     */
    private static class InstanceHolder {
        private static final ThreadTest instance = new ThreadTest();
    }

    public ThreadTest getInstance2() {
        return InstanceHolder.instance;
    }


    public static void main(String[] args) {
        System.out.println("java内存模型");
    }
}
