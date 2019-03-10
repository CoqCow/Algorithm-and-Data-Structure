package com.niu.aqiyi;

import java.util.Scanner;

public class Code_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        int[] arrs = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arrs[i] = Integer.parseInt(chars[i] + "");
        }
        int lowSum = arrs[0] + arrs[1] + arrs[2];
        int heighSum = arrs[3] + arrs[4] + arrs[5];
        int tmp = lowSum - heighSum;
        if (tmp == 0) {
            System.out.println(0);
        } else if (tmp < 0) {
            int min = 0;
            int count=0;
            while (lowSum<heighSum){
                for(int i=0;i<3;i++){
                    if(arrs[i]<arrs[min]){
                        min=i;
                    }
                }
                if(arrs[min]==9) break;
                if(lowSum-arrs[min]+9>=heighSum){
                    count++;
                    break;
                }else {
                    count++;
                    lowSum=lowSum-arrs[min]+9;
                    arrs[min]=9;
                }
            }
            System.out.println(count);
        } else {
            int min = 3;
            int count=0;
            while (heighSum<lowSum){
                for(int i=3;i<6;i++){
                    if(arrs[i]<arrs[min]){
                        min=i;
                    }
                }
                if(heighSum-arrs[min]+9>=lowSum){
                    count++;
                    break;
                }else {
                    count++;
                    heighSum=heighSum-arrs[min]+9;
                    arrs[min]=9;
                }
            }
            System.out.println(count);
        }

    }
}
/*
            int min = arrs[0] < arrs[1] ? 0 : 1;
            min = arrs[min] < arrs[2] ? min : 2;
            int max = arrs[0] > arrs[1] ? 0 : 1;
            max = arrs[min] > arrs[2] ? min : 2;
            int mid = 0;
            for (int i = 0; i < 3; i++) {
                if (arrs[i] > arrs[min] && arrs[i] < arrs[max]) {
                    mid = i;
                }
            }
            int count=0;
            if (lowSum-arrs[min]+9>tmp) {
                count++;
            }else {
                count++;
                lowSum=lowSum-arrs[min]+9;
                if(lowSum-arrs[mid]+9>tmp){
                    count++;
                }else {
                    count++;
                    lowSum=lowSum-arrs[mid]+9;
                    if (lowSum-arrs[max]+9>tmp){
                        count++;
                    }
                }
            }
            System.out.println(count);
 */
