package com.oneline.other;

public class FanxingTest {
    public static void main(String[] args) {

    }

    public abstract class Man<T> {
        private T t;

        abstract void getSuccess(T t);

        abstract void failed();
    }
}
