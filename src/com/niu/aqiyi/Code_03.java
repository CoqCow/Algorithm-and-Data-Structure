package com.niu.aqiyi;

import java.util.HashSet;
import java.util.Scanner;

public class Code_03 {

    public static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        int np = in.nextInt();
        int nq = in.nextInt();
        int nr = in.nextInt();
        for (int i = 0; i < np; i++) {
            s.append('P');
        }
        for (int i = 0; i < nq; i++) {
            s.append('Q');
        }
        for (int i = 0; i < nr; i++) {
            s.append('R');
        }
        char[] chars = s.toString().toCharArray();

        process(chars, 0, s.length() - 1);
        System.out.println(res);
    }

    public static void process(char[] chars, int start, int end) {
        if (start == end) {
            for (int i = 1; i <= end; i++) {
                if (chars[i] == chars[i - 1]) return;
            }
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i <= end; i++) {
                tmp.append(chars[i]);
            }
            System.out.println(tmp.toString());
            res++;
        } else {
            for (int i = start; i <= end; i++) {
                if (i != start && chars[i] == chars[start]) continue;
                swap(chars, i, start);
                process(chars, start + 1, end);
                swap(chars, i, start);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}