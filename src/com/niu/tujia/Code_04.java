package com.niu.tujia;


import java.util.Scanner;

public class Code_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int MaxNum = -1;
        int curNum = 0;
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - '0';
            if (tmp >= 0 && tmp <= 9) {
                curNum = curNum * 10 + tmp;
            } else {
                if (MaxNum == -1 || MaxNum < curNum) {
                    MaxNum = curNum;
                }
                curNum = 0;
            }
        }
        if(MaxNum!=-1)
        System.out.println(MaxNum);//I66LOVE5228BOSS99ZP
    }
}
