package com.niu.tujia;

import java.util.Scanner;

public class Code_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int curNum = 1;
        int curTime = 1;
        for (int i = 1; i <= n; i++) {
            if(--curTime==0){
                curNum++;
                curTime=curNum;
            }
        }
        System.out.println(curNum);
    }
}
