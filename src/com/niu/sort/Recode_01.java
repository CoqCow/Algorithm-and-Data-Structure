package com.niu.sort;

import java.util.Arrays;

public class Recode_01 {
    public static void main(String[] args) {
        int testTime = 10;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] tmp = new int[arr1.length];
            //bubble_sort(arr1);//冒泡排序
            //select_sort(arr1);//选择排序
            //insert_sort(arr1);//插入排序
            //mergeSort(arr1, tmp, 0, arr1.length - 1);//归并排序
            //quickSort(arr1, 0, arr1.length - 1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }

        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    //随机数组发生器
    public static int[] generateRandomArray(int size, int value) {
        //int[] arr = new int[(int) ((size + 1) * Math.random())];//[0,1)
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random());
//            arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value + 1) * Math.random());
        }
        return arr;
    }

    //数组复制
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    //交换数组
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //java 排序
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    //冒泡排序
    public static void bubble_sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = false;
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!flag) return;
        }
    }

    //选择排序
    public static void select_sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int end = arr.length - 1; end > 0; end--) {
            int index = 0;
            for (int i = 1; i <= end; i++) {
                if (arr[i] > arr[index]) index = i;
            }
            swap(arr, index, end);
        }
    }

    //插入排序
    public static void insert_sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] a, int[] b, int left, int right) {
        if (left >= right) return;
        int middle = left + ((right - left) >> 1);
        mergeSort(a, b, left, middle);
        mergeSort(a, b, middle + 1, right);
        mergeSortedArray(a, b, left, middle, right);
    }

    //合并两个有序数组
    public static void mergeSortedArray(int[] a, int[] b, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= middle) {
            b[k++] = a[i++];
        }
        while (j <= right) {
            b[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[left + i] = b[i];
        }
    }

    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) return;
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0] - 1);
        quickSort(arr, p[1] + 1, right);
    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    //堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}

