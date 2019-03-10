package com.niu.random;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Code_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] data = s.split(" ");
        int k = Integer.parseInt(data[data.length - 1]);
        int length = data.length - 1;
        if (k > length) return;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < data.length - 1; i++) {
            if (i < k) {
                queue.add(Integer.valueOf(data[i]));
            } else {
                if (queue.peek() > Integer.valueOf(data[i])) {
                    queue.poll();
                    queue.add(Integer.valueOf(data[i]));
                }
            }
        }
        int[] res=new int[k];
        for (int i = 0; i < Integer.valueOf(data[data.length - 1]); i++) {
            res[i]=queue.poll();
        }
        for(int i=res.length-1;i>=0;i--){
            if (i == res.length-1) {
                System.out.printf(res[i] + "");
            } else {
                System.out.printf(" " + res[i]);
            }
        }
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
