package com.niu.aqiyi;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 2};
        for (int a : getMinNums(arr, 3)) {
            System.out.print(" " + a);
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        input=getMinNums(input,k);
        if(input==null) return null;
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=0;i<k;i++) {
            res.add(input[i]);
        }
        return res;
    }
    public static int[] getMinNums(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            return null;
        }
        int[] res = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                res[i] = arr[i];
                insert(res, i);
            } else {
                if (arr[i] < res[0]) {
                    res[0] = arr[i];
                    heapify(res, k);
                }
            }
        }
        return res;
    }

    public static void insert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int size) {
        int index = 0;
        int left = index * 2 + 1;
        while (left < size) {
            int larget = (left + 1 < size) && (arr[left + 1] > arr[left]) ? left + 1 : left;
            larget = arr[index] > arr[larget] ? index : larget;
            if (larget == index) return;
            index = larget;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
