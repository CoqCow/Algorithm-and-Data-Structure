package com.niu.ok;

import java.util.Scanner;

public class Code_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        getMinStep(arr);
    }

    public static int getMinStep(int[] arr) {
        int cur = 0;
        int next = 0;
        int jump = 0;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
                System.out.printf(i + " ");
            }
            next = Math.max(next, i + arr[i]);
            if (i + arr[i] > next) flag = i;
        }
        return jump;
    }
}
