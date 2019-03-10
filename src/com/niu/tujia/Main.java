package com.niu.tujia;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int m = in.nextInt();
        int maxV = 0;
        int[] weight = new int[s];
        int[] value = new int[s];
        double[] rate = new double[s];
        for (int i = 0; i < s; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
            rate[i] = value[i] / weight[i];
        }
        for (int i = 0; i < s; i++) {
            int index = getMaxIndex(rate);
            if (rate[index] == -1) {
                break;
            } else {
                if (m - weight[index] >= 0) {
                    m = m - weight[index];
                    maxV += value[index];
                    rate[index] = -1;
                } else {
                    rate[index] = -1;
                }
            }
        }
        System.out.println(maxV);
    }

    public static int getMaxIndex(double[] rate) {
        int tmp = 0;// 10/10
        for (int i = 1; i < rate.length; i++) {
            if (rate[i] != -1 && rate[i] > rate[tmp]) {
                tmp = i;
            }
        }
        return tmp;
    }

}
