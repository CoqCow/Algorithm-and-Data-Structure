package com.niu.random;

import java.util.Scanner;

public class Code_06 {
    public static StringBuilder builder = new StringBuilder("[");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int max = n - m + 1;
        int[] nodes = new int[m];
        for (int i = 0; i < m; i++) {
            nodes[i] = 1;
        }
        process(nodes, 0, n, max);
        builder.append("]");
        builder.replace((builder.length()-2),builder.length()-1,"");
        System.out.println(builder.toString());
    }

    public static void process(int[] nodes, int begin, int terget, int max) {
        if (begin>=nodes.length||getSum(nodes, begin) > terget) {
            return;
        }


        for (int i = 1; i <= max; i++) {
            nodes[begin]=i;
            if (getSum(nodes, begin) <= terget) {
                //添加
                builder.append("[");
                for (int j = 0; j < nodes.length; j++) {
                    if (j != nodes.length - 1)
                        builder.append(nodes[j] + ",");
                    else {
                        builder.append(nodes[j]);
                    }
                }
                builder.append("],");
            }
            process(nodes, begin + 1, terget - i, max);
        }
    }

    public static int getSum(int[] nodes, int begin) {
        int sum = 0;
        for (int i = begin; i < nodes.length; i++) {
            sum += nodes[i];
        }
        return sum;
    }
}
