package com.niu.interview;

class Parent {
    public static String value = "fddd";

    static {
        System.out.println("init parent");
    }
}

class SubClass extends Parent {
    static {
        System.out.println("init SubClass");
    }
}
public class  Main{
    public static void main(String[] args) {
        String value = "fddd";
        System.out.println(value);
        System.out.println(Parent.value);
    }
}
