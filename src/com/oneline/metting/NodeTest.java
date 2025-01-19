package com.oneline.metting;

/**
 * 用链表实现查找到节点的index和node的value相同时，删除该节点
 */
public class NodeTest {

    public static void main(String[] args) {
        NodeTest list = new NodeTest();
        list.append(2);
        list.append(5);
        list.append(7);
        list.append(8);
        list.append(4);

        System.out.println("原始链表:");
        list.printList();

        list.deleteNodeIfIndexEqualsValue();

        System.out.println("删除后的链表:");
        list.printList();
    }

    private ListNode head;

    // 插入节点到链表末尾
    public void append(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    // 删除节点，当节点的索引和值相同时
    public void deleteNodeIfIndexEqualsValue() {
        ListNode current = head;
        ListNode previous = null;
        int index = 0;

        while (current != null) {
            if (current.value == index) {
                if (previous == null) {
                    // 如果要删除的是头节点
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
            } else {
                previous = current;
            }
            current = current.next;
            index++;
        }
    }

    // 打印链表
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
