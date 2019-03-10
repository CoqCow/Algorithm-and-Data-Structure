package com.niu.sort;


import java.util.Arrays;

/**
 * Created by Lenovo on 2018/4/23.
 * 这个类总结各种排序算法
 */
public class Main {
    public static void main(String[] args) {
        int testTime = 10;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] tmp = new int[arr1.length];
            //bubble_sort(arr1);//冒泡排序
            // select_sort(arr1);//选择排序
            // insert_sort(arr1);//插入排序
            //MergeSort(arr1, tmp, 0, arr1.length - 1);//归并排序
            //quickSort(arr1, 0, arr1.length - 1);
            heapSort(arr1);
            //testBSearch();
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

    //java 排序
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    //冒泡排序
    public static void bubble_sort(int[] arr) {
        //不合法检验
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = false;//如果一趟中没有发生交换说明已经是排好序的了
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    //选择排序
    public static void select_sort(int[] arr) {
        //不合法检验
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            if (minIndex != i) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }


    }

    //插入排序
    public static void insert_sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }

    //归并排序实现
    public static void MergeSort(int[] a, int[] b, int left, int right) {
        //当left==right的时，已经不需要再划分了
        if (left >= right) return;
        int middle = left + ((right - left) >> 1);
        MergeSort(a, b, left, middle);          //左子数组
        MergeSort(a, b, middle + 1, right);       //右子数组
        mergeSortedArray(a, b, left, middle, right);    //合并两个子数组
    }

    // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
    public static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //把数据复制回原数组
        for (i = 0; i < k; ++i) {
            arr[left + i] = temp[i];
        }
    }

    //快速排序 空间复杂度O(logN) 时间复杂度O(N*logN)
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
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

    //荷兰国旗问题
    public static void netherlandsFlag(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int value = arr[arr.length / 2];
        int less = -1;
        int right = arr.length;
        int cur = 0;
        while (cur < right) {
            if (arr[cur] < value) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > value) {
                swap(arr, cur, --right);
            } else {
                cur++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //堆排序  时间复杂度O(N*logN) 空间O（1）
    public static void heapSort(int[] arrs) {
        if (arrs == null || arrs.length < 2) return;
        for (int i = 0; i < arrs.length; i++) {
            heapInsert(arrs, i);
        }
        int size = arrs.length - 1;
        swap(arrs, 0, size);
        while (size > 0) {
            heapify(arrs, 0, size);
            swap(arrs, 0, --size);
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

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) break;

            swap(arr, largest, index);

            index = largest;
            left = index * 2 + 1;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int tmp=arr[i];

            }
        }
    }

    public static void testBSearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(arr);
        System.out.println(binarySearch(arr, 0));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 2));
        System.out.println(binarySearch(arr, 6));
        System.out.println(binarySearch(arr, 7));
        System.out.println(binarySearch(arr, 9));

    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
