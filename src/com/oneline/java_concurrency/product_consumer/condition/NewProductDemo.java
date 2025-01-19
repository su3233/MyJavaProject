package com.oneline.java_concurrency.product_consumer.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewProductDemo {

    public static void main(String[] args) {

        Data2 data = new Data2();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.increase();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.increase();
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.decrease();
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<4;i++){
                data.decrease();
            }
        },"D").start();
    }
}

//判断等待；业务；通知
class Data2{

    private int num=0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increase(){
        lock.lock();
        try {
            while (num!=0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrease(){
        lock.lock();
        try {
            while (num==0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
