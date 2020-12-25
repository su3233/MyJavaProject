package com.oneline.test;

public class RawClass extends ExtendsClass {
    @Override
    public void getName() {
        System.out.println("RawClass-getName_pre");
        super.getName();
        System.out.println("RawClass-getName-after");
    }
}
