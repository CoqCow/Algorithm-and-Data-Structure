package com.niu.aqiyi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Code_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int P = in.nextInt();
        int[] foods = new int[N + 1];
        for (int i = 1; i < foods.length; i++) {
            foods[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < M; i++) {
            String s = in.nextLine();
            String[] strings = s.split(" ");
            if (strings[0].equals("A")) {
                int index = Integer.parseInt(strings[1]);
                foods[index] = foods[index] + 1;
            } else {
                int index = Integer.parseInt(strings[1]);
                foods[index] = foods[index] - 1;
            }
        }
        int pNum = foods[P];
        int num = 1;
        foods[0] = Integer.MIN_VALUE;
        Arrays.sort(foods);
        for (int i = foods.length-1; i >=0; i--) {
            if (foods[i] > pNum) {
                num++;
                for (int j = i - 1; j >=0 && foods[j] == foods[j - 1]; j--, i--) {

                }
            }else {
                break;
            }
        }
        System.out.println(num);
    }
}
