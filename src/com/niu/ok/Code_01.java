package com.niu.ok;

import java.util.Scanner;

public class Code_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = getN(n);
        int count = 0;
        if (sum == 0) {
            System.out.println(1);
            return;
        }
        while ((sum % 10) == 0) {
            count++;
            sum = sum / 10;
        }
        System.out.println(count);
    }

    public static int getN1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return n * getN1(n - 1);
    }

    public static int getN(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
