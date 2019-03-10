package com.niu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Code_04_BalanceAndSearchTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData {
        public boolean isBalance;
        public int h;

        public ReturnData(boolean isBalance, int h) {
            this.isBalance = isBalance;
            this.h = h;
        }
    }

    public static ReturnData process(Node head) {
        if (head == null) return new ReturnData(true, 0);
        ReturnData leftDate = process(head.left);
        if (!leftDate.isBalance) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isBalance) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftDate.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }

        return new ReturnData(true, Math.max(leftDate.h, rightData.h) + 1);
    }

    public static boolean isBalance(Node head) {
        return process(head).isBalance;
    }

    public static boolean isCBT(Node head) {
        if (head == null) return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) queue.offer(l);
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    //统计完全二叉树节点个数 时间复杂度O（logn）的平方
    public static int nodeNum(Node head) {
        if (head == null) return 0;

        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(Node node, int level, int h) {
        if (level == h) return 1;
        if (mostLeftLevel(node.right, level++) == h) {
            return (1 << (h - level) + bs(node.right, level++, h));
        } else {
            return (bs(node.left, level++, h) + 1 << (h - level - 1));
        }
    }

    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}

