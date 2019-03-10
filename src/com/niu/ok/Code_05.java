package com.niu.ok;

import java.util.Scanner;

public class Code_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int[] arr = new int[strings.length];
        if (arr.length == 2) {
            System.out.println(Math.abs(Integer.parseInt(strings[0]) - Integer.parseInt(strings[1])));
            return;
        }
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        leftArr[0] = arr[0];
        rightArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = Math.min(arr[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i > -1; i--) {
            rightArr[i] = Math.min(arr[i + 1], arr[i]);
        }
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min,Math.abs(leftArr[i]-rightArr[i+1]));
        }
        System.out.println(min);
    }
}
