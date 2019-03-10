package com.niu.random;

import java.util.Scanner;

public class Code_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int num = 0;
        for (int a = 1; a <= N; a++) {
            for (int b = a; b <= N; b++) {
                for (int c = b; c <= N; c++) {
                    if ((a + b) < c || Math.abs(a - b) > c) {
                        continue;
                    }
                    if ((a * a + b * b) == (c * c)) {
                        if (isOk(a, b, c))
                            num++;
                    }
                }
            }
        }
        System.out.println(num);
    }

    public static boolean isOk(int a, int b, int c) {

        for (int i = 2; i < c; i++) {
            if (a % i == 0 && b % i == 0 && c % i == 0) {
                return false;
            }
        }
        return true;
    }
}


