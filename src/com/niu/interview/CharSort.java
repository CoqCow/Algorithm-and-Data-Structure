package com.niu.interview;

public class CharSort {
    public static void main(String[] args) {
        String s = "abc";
        char[] chars = s.toCharArray();
        process(chars, 0, 2);
    }

    public static void process(char[] chars, int start, int end) {
        if (start == end) {
            for (int i = 0; i <= end; i++) {
                System.out.print(chars[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(chars,i,start);
                process(chars,start+1,end);
                swap(chars,i,start);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
