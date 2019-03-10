package com.niu.ok;


import java.util.Scanner;

public class Code_09 {
   public static int k,b,n,t;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         k=scanner.nextInt();
         b=scanner.nextInt();
         n=scanner.nextInt();
         t=scanner.nextInt();
        int z=1;
         for(int i=1;i<=n;i++){
            z=z*k+b;
        }
        int sec=0;
        while (t<z){
            sec++;
            t=t*k+b;
        }
        System.out.println(sec);
    }

}
