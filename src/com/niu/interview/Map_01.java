package com.niu.interview;

import java.util.*;
/*
* 并查集
* */
public class Map_01 {
    public static class Node {
        public Set<Integer> friends = new HashSet<>();
    }

    public static HashMap<Node, Node> fatherMap;
    public static HashMap<Node, Integer> sizeMap;

    public static void main(String[] args) {
        //1、输入数据，组织数据结构
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0 || n >= 100000) {
            System.out.println(0);
            return;
        }
        Node[] nodes = new Node[n + 1];
        int tmp;
        fatherMap = new HashMap<Node, Node>();
        sizeMap = new HashMap<Node, Integer>();
        for (int i = 1; i <= n; ++i) {
            nodes[i] = new Node();
            fatherMap.put(nodes[i], nodes[i]);
            sizeMap.put(nodes[i], 1);
            while ((tmp = sc.nextInt()) != 0) {
                nodes[i].friends.add(tmp);
            }
        }
        //2、遍历每个节点，根据合并策略进行合并
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].friends.size() == 0) continue;
            for (Iterator<Integer> iterator = nodes[i].friends.iterator(); iterator.hasNext(); ) {
                Integer one = iterator.next();
                if (!isSameSet(nodes[i], nodes[one])) {
                    union(nodes[i], nodes[one]);
                    n--;
                }
            }
        }
        //3、result
        System.out.println(n);
    }

    private static Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public static boolean isSameSet(Node a, Node b) {
        return findHead(a) == findHead(b);
    }

    public static void union(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        if (aHead != bHead) {
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            if (aSetSize <= bSetSize) {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSetSize + bSetSize);
            } else {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSetSize + bSetSize);
            }
        }
    }
}
