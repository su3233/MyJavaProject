package com.oneline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedTest {
    public static void main(String[] args) {
        //数组实现
        List<String> array = new ArrayList<>();
        //链表实现
        List<String> linked = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            array.add("ont line");
        }
        long end = System.nanoTime();
        System.out.println("array：" + (end - start));

        long start2 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linked.add("ont line");
        }
        long end2 = System.nanoTime();
        System.out.println("array：" + (end2 - start2));
    }
}
