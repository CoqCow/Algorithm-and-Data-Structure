package com.niu.ok;

import java.util.Scanner;

public class Code_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            int tmp = i;
            while (tmp % 5 == 0) {
                count++;
                tmp /= 5;
            }
        }
        System.out.println(count);
    }

    public static long getN(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return n * getN(n - 1);
    }
}
