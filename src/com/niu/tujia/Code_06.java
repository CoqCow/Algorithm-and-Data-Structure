package com.niu.tujia;

import java.util.Scanner;
import java.util.Stack;

public class Code_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        if (in.startsWith("+") || in.startsWith("-") || in.startsWith("*") || in.startsWith("/")) {
            System.out.println("False");
        }
        //3*13+5*(23+4*(3+5))
        Stack<Character> stack = new Stack<>();
        int a=0;
        int b=0;
        for (int i = 0; i < in.length(); i++) {
            if(in.charAt(i)=='('){
                a++;
            }
            if(in.charAt(i)==')'){
                b++;
            }
        }
        if(a!=b){
            System.out.println("False");
            return;
        }
        for (int i = 0; i < in.length(); i++) {
            int tmp = in.charAt(i) - '0';
            if (tmp >= 0 && tmp <= 9) {
                stack.push(in.charAt(i));
            }else {
                if(!stack.isEmpty()){
                    int tmp2=stack.peek()-'0';
                    if(!(tmp2 >= 0 && tmp2 <= 9)){
                        System.out.println("False");
                        return;
                    }
                }else {
                    stack.push(in.charAt(i));
                }
            }
        }
        System.out.println("True");
    }
}
