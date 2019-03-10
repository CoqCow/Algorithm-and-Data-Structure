package com.niu.beike2;
/*
*
10
1 -1
3 1
4 1
5 1
6 1
7 1
8 1
9 1
10 1
2 10
5
1 2
2 3
2 4
2 5
2 10
2 3
*
* */
import java.util.HashMap;
import java.util.Scanner;

public class Code_02 {
    public static class Node {
    }

    public static HashMap<Node, Node> fatherMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            //System.out.println("a="+a+"b="+b);
            if (b == -1) {
                if (nodes[a] == null) {
                    nodes[a] = new Node();
                    fatherMap.put(nodes[a], nodes[a]);
                    System.out.println("fatherMap.put "+a+" and "+a);
                }
            } else {
                if (nodes[a] == null) {
                    nodes[a] = new Node();
                }
                if (nodes[b] == null) {
                    nodes[b] = new Node();
                }
                if (fatherMap.get(nodes[a]) != null) {
                    fatherMap.put(nodes[b], nodes[a]);
                    System.out.println("fatherMap.put "+b+" and "+a);
                } else {
                    fatherMap.put(nodes[a], nodes[b]);
                    System.out.println("fatherMap.put "+a+" and "+b);
                }

            }

        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println(whoisFather(nodes[A], nodes[B]));
        }


    }


    public static int whoisFather(Node A, Node B) {

        Node father = fatherMap.get(A);
        Node tmp=A;
        while (father != tmp) {
            if (father == B) {
                return 2;
            }
            tmp=father;
            father = fatherMap.get(father);
        }
        father = fatherMap.get(B);
        tmp=B;
        while (father != tmp) {
            if (father == A) return 1;
            tmp=father;
            father = fatherMap.get(father);

        }
        return 0;
    }

}
