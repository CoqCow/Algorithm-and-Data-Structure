package com.niu.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Code_03 {
    public static void main(String[] args) {
        float d=5.65f;
        float d2=5.65f;
        System.out.println(d==d2);
        /*        int [] pushA={1,2,3};
        int [] popA={1,2,3};
        IsPopOrder(pushA,popA);*/
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=popA.length)return false;
        Stack<Integer> st=new Stack<>();
        int j=0;
        st.push(pushA[j++]);
        for(int i=0;i<popA.length;i++){
            if(st.isEmpty()){
                st.push(pushA[j++]);
            }
            while(popA[i]!=st.peek()){
                if(j==pushA.length) return false;
                st.push(pushA[j++]);
            }
            st.pop();
        }
        return true;
    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }
        return 0;
    }
    public String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(str.charAt(i));
            }
        }
        str=stringBuffer;
        return str.toString();
    }
}