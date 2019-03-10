package com.niu.ok;

import java.util.Scanner;

public class Code_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        int num = 0;
        for (long i = l; i <= r; i++) {
            String s=i+"";
            if(s.charAt(0)==s.charAt(s.length()-1)&&s.charAt(0)!='0') num++;
        }
        System.out.println(num);
    }
}
