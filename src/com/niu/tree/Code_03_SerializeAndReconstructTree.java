package com.niu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Code_03_SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) return "#_";
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String one : values) {
            queue.offer(one);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) return null;
        Node node = new Node(Integer.valueOf(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }

    public static void preOrderTraverse(Node head) {
        if (head == null) return;
        System.out.printf(head.value + " ");
        preOrderTraverse(head.left);
        preOrderTraverse(head.right);
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println("--------------------------------");
        System.out.printf("preOrderTraverse:");
        preOrderTraverse(head);
        System.out.println();
        System.out.println("serialByPre:" + serialByPre(head));
        System.out.printf("reConPreOrder:");
        preOrderTraverse(reconByPreString(serialByPre(head)));
        System.out.println();
    }
}
