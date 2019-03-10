package com.niu.random;

import java.util.Random;

public class Code_04 {
    public static void main(String[] args) {
        int a = 100;
        while (a-- != 0) {
           int t=new Random().nextInt(1000);
           if(NumberOf1(t)!=NumberOf2(t)){
               System.out.println("fuck");
                break;
            }
        }
        System.out.println("nice");
    }

    public static int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}


