package com.niu.ok;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int cur = 0;
        int flag = 0;
        for (int i = 0; i < N; i++) {
            if (flag == 0) {
                cur = arr[i];
                flag++;
            } else if (cur == arr[i]) {
                flag++;
            } else {
                flag--;
            }
        }
        System.out.println(cur);
    }
}
