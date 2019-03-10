package com.niu.ok;

import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Code_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int[] arr = new int[strings.length];
        if (arr.length == 2) {
            System.out.println(Math.abs(Integer.parseInt(strings[0]) - Integer.parseInt(strings[1])));
            return;
        }
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new myC());
        int min = 0;
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            if (maxQ.isEmpty()) {
                maxQ.add(arr[i]);
                max++;
                continue;
            }
            if (maxQ.peek() >= arr[i]) {
                maxQ.add(arr[i]);
                max++;
            } else {
                if (minQ.isEmpty()) {
                    minQ.add(arr[i]);
                    min++;
                    continue;
                }
                if (minQ.peek() > arr[i]) {
                    maxQ.add(arr[i]);
                    max++;
                } else {
                    minQ.add(arr[i]);
                    min++;
                }
            }
            //resize
            if (max == min + 2) {
                minQ.add(maxQ.poll());
                min++;
                max--;
            }
            if (min == max + 2) {
                maxQ.add(minQ.poll());
                max++;
                min--;
            }
        }
        while (!maxQ.isEmpty()){
            System.out.print(maxQ.poll()+" ");
        }
        System.out.println();
        while (!minQ.isEmpty()){
            System.out.print(minQ.poll()+" ");
        }
    }

    public static class myC implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
