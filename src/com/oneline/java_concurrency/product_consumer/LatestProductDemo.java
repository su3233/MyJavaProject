package com.oneline.java_concurrency.product_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LatestProductDemo {
    public static void main(String[] args) {

        Data3 data = new Data3();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.showA();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.showB();
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.showC();
            }
        },"C").start();
    }
}

//判断等待；业务；通知
class Data3{

    private int num=1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void showA(){
        lock.lock();

        try {
            while (num!=1) {
                condition1.await();
            }
            num=2;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void showB(){
        lock.lock();

        try {
            while (num!=2) {
                condition2.await();
            }
            num=3;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void showC(){
        lock.lock();
        try {
            while (num!=3) {
                condition3.await();
            }
            num=1;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
