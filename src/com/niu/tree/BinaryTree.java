package com.niu.tree;

public class BinaryTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        String value;

        public TreeNode(String value) {
            this.value = value;
        }
    }

    public static void insertNode(TreeNode head, TreeNode node) {
        if (node == null || head == null) return;
        if (node.value.compareTo(head.value) < 0) {
            if (head.left == null) {
                head.left = node;
            } else {
                insertNode(head.left, node);
            }
        } else {
            if (head.right == null) {
                head.right = node;
            } else {
                insertNode(head.right, node);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode("0");
        TreeNode node1 = new TreeNode("1");
        TreeNode node2 = new TreeNode("2");
        TreeNode node3 = new TreeNode("3");
        TreeNode node4 = new TreeNode("4");
        TreeNode node5 = new TreeNode("5");
        TreeNode node6 = new TreeNode("6");
        insertNode(head, node1);
        insertNode(head, node2);
        insertNode(head, node3);
        insertNode(head, node4);
        insertNode(head, node5);
        insertNode(head, node6);
        print(head);
    }

    public static void print(TreeNode head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        print(head.left);
        print(head.right);

    }
}
