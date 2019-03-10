package com.niu.ok;

import java.util.Scanner;

public class Code_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
/*        int tR = 0, tC = 0, dR = arr.length - 1, dC = arr[0].length - 1;
        while (tR < dR) {
            resizeArr(arr, tR++, tC++, dR--, dC--);
        }*/
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                System.out.println(arr[j][i]);
            }
        }
    }

    public static void resizeArr(int[][] arr, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = arr[tR][tC + i];
            arr[tR][tC + i] = arr[dR - i][tC];
            arr[dR - i][tC] = arr[dR][dC - i];
            arr[dR][dC - i] = arr[tR + i][dC];
            arr[tR + i][dC] = tmp;
        }
    }
}
