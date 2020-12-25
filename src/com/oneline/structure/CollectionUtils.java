package com.oneline.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CollectionUtils {
    public static void main(String[] args) {
        LinkedHashMapTest linkedHashMapTest = new LinkedHashMapTest();
        linkedHashMapTest.add();
        linkedHashMapTest.read();
        linkedHashMapTest.delete(3);

        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.add();
        arrayListTest.read();
        arrayListTest.delete(3);
//        arrayListTest.read();
    }

    /**
     * 基于动态数组。可以随机访问
     */
    static class ArrayListTest {
        ArrayList<String> arrayList;

        public ArrayListTest() {
            arrayList = new ArrayList<>();
        }

        public void add() {
            for (int i = 0; i < 10; i++) {
                arrayList.add("arrayList_" + i);
            }
        }

        private void delete(int m) {
            if (m < arrayList.size()) {
                arrayList.remove(m);
            }
        }

        private void read() {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println("ArrayList_" + arrayList.get(i));
            }
        }
    }

    static class LinkedHashMapTest {
        LinkedHashMap<String, String> linkedHashMap;

        public LinkedHashMapTest() {
            linkedHashMap = new LinkedHashMap<>();
        }

        public void add() {
            for (int i = 0; i < 10; i++) {
                linkedHashMap.put("key" + i, "value" + i);
            }
        }

        private void delete(int m) {
            for (int i = 0; i < linkedHashMap.size(); i++) {
                if (linkedHashMap.containsKey("key" + m)) {
                    linkedHashMap.remove("key" + m);
                }
            }
        }

        private void read() {
            Set<String> keySet = linkedHashMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                System.out.println(key + "--" + linkedHashMap.get(iterator.next()));
            }
        }
    }
}
