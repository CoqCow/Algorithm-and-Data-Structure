package com.niu.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MainTest {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 12, 7, 10, 1, 2};
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MaxIntegerComparator());
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr3[i]);
            heapInsert(arr, i);
            heapSInsert(arr2, i);
        }
        printArray(arr);
        printArray(arr2);
        while (!priorityQueue.isEmpty()) {
            System.out.printf(priorityQueue.poll() + " ");
        }
    }

    //调节为大根堆
    public static void heapInsert(int[] arrs, int index) {
        while (arrs[index] > arrs[(index - 1) / 2]) {
            swap(arrs, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //调节为小根堆
    public static void heapSInsert(int[] arrs, int index) {
        while (arrs[index] < arrs[(index - 1) / 2]) {
            swap(arrs, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static class MaxIntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
