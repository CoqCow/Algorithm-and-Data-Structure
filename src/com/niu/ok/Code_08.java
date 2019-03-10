package com.niu.ok;

import java.util.Scanner;

public class Code_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] begins = s1.split(":");
        String[] adds = s2.split(":");
        StringBuilder builder = new StringBuilder();
        int m = 0, h = 0;
        int s = Integer.parseInt(begins[2]) + Integer.parseInt(adds[2]);
        if (s >= 60) {
            s = s - 60;
            m++;
        }
        m += Integer.parseInt(begins[1]) + Integer.parseInt(adds[1]);
        if (m >= 60) {
            m = m - 60;
            h++;
        }
        h += Integer.parseInt(begins[0]) + Integer.parseInt(adds[0]);
        if (h >= 24) {
            h = h - 24;
        }
        if (h == 0) {
            builder.append("00:");
        } else if (h <= 9) {
            builder.append("0" + h + ":");
        } else {
            builder.append(h + ":");
        }
        if (m == 0) {
            builder.append("00:");
        } else if (m <= 9) {
            builder.append("0" + m + ":");
        } else {
            builder.append(m + ":");
        }
        if (s == 0) {
            builder.append("00");
        } else if (s <= 9) {
            builder.append("0" + s);
        } else {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }
}
