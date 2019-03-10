package com.niu.interview;

/**
 * Created by Lenovo on 2018/4/5.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},null,null);
        Stack<Integer> s1 = new Stack<Integer>();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {1, 3, 2, 4, 5};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove(0));
        System.out.println(list.remove(0));

    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                map.remove(array[i]);
            }
        }
        Set<Integer> set = map.keySet();

        boolean b = true;
        for (Integer one : set) {
            if (b) {
                num1[0] = one;
                b = false;
            }else {
                num2[0] = one;
            }

        }

    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;
        Stack<Integer> st = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            st.push(pushA[i]);
            while (!st.isEmpty() && popA[j] == st.peek()) {
                j++;
                st.pop();
            }
        }
        return st.isEmpty();
    }

}
