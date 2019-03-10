package com.niu.tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (true){
            String s=in.next();
            s=s.replace("吗","");
            s=s.replace("？","！");
            s=s.replace("？","！");
            System.out.println(s);
        }
    }
}