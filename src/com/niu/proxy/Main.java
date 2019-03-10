package com.niu.proxy;

public class Main {
    public static void main(String[] args) {
        Target target=new JdkDynamicProxyTest().newProxyInstance(new TargetImpl());
        System.out.println(target.test(4));
    }
}
