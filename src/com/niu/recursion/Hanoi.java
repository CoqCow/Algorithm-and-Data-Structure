package com.niu.recursion;

public class Hanoi {
    public static int n=0;
    public static void main(String[] args) {
       // process(2, "左", "右", "help");

        printAllSubsquence("abc");
        System.out.printf("n="+n);
    }

    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            process(N - 1, from, help, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            process(N - 1, help, to, help);
        }

    }
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            n++;
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }
}
