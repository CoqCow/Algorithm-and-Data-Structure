package com.niu.tujia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Code_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int k = 0; k < T; k++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            int res = 0;
            for (int i = 0; i < list.size() - 1; ) {
                boolean flag = false;
                for (int j = i + 1; j < list.size(); j++) {
                    int tmp = Math.abs(list.get(i) - list.get(j));
                    if (!list.contains(tmp)) {
                        list.add(tmp);
                        res++;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    i = 0;
                } else {
                    i++;
                }
            }
            System.out.println(res);
        }
    }

}
/*
1
6 5 4
*
 */
