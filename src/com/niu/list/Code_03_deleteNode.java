package com.niu.list;

import java.util.ArrayList;
import java.util.HashMap;

public class Code_03_deleteNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put(null, null);
        arrayList.add(1);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i <= 10; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = deleteKNode2(head, 2);
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static Node deleteNodes(Node head) {
        if (head == null) return null;
        Node newHead = head.next;
        Node cur = newHead;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return newHead;
    }

    public static Node deleteNodes2(Node head) {
        if (head == null) return null;
        Node newHead = head.next;
        Node cur = newHead;
        Node pre = head;
        int index = 2;
        while (cur != null) {
            if (index % 2 == 1) {
                pre.next = cur.next;
                cur = cur.next;
                index++;
            } else {
                pre = cur;
                cur = cur.next;
                index++;
            }
        }
        return newHead;
    }

    public static Node deleteKNode(Node head, int k) {
        if (head == null || k < 1) return head;
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) return head.next;
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static Node deleteKNode2(Node head, int k) {
        if (head == null || k < 1) return head;
        Node fast = head;
        Node slow = null;
        while (k-- > 0) {
            fast = fast.next;
            if (fast == null && k == 0) return head.next;
            if (fast == null) return head;
        }
        slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
