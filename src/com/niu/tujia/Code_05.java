package com.niu.tujia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Code_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        char[] chars = (num + "").toCharArray();
        String[] s_badNums = input.split(",");
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < s_badNums.length; i++) {
            hashSet.add(s_badNums[i]);
        }
        boolean b = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            int tmp = chars[i] - '0';
            if (hashSet.contains(tmp + "")) {
                char c = '1';
                for (int j = tmp + 1; j <= 9; j++, c++) {
                    if (!hashSet.contains(c + "")) {
                        chars[i] = c;
                        b = true;
                        break;
                    }
                }
                continue;
            }
            if (tmp != 0 && !b) {
                char c = '1';
                for (int j = 1; j <= 9; j++, c++) {
                    if (j > tmp && !hashSet.contains(j + "")) {
                        chars[i] = c;
                        b = true;
                        break;
                    }
                }
            } else if (tmp == 0) {
                char c = '1';
                for (int j = 1; j <= 9; j++, c++) {
                    if (!hashSet.contains(c + "")) {
                        chars[i] = c;
                        b = true;
                        break;
                    }
                }
            }
        }
        System.out.println(chars);
    }

    public static int getValue(char[] chars) {
        int res = 0;
        for (char c : chars) {
            res = res * 10 + (c - '0');
        }
        return res;
    }
}
