package com.niu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyTest implements InvocationHandler {
    private Target target;

    public Target newProxyInstance(Target target) {
        this.target = target;
        return (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("test".equals(method.getName()))
        checkPopedom();
        Object res = method.invoke(target, args);
        saveLog();
        return res;
    }

    private void checkPopedom() {//模拟检查权限的例子
        System.out.println(".:检查权限  checkPopedom()!");
    }

    private void saveLog() {
        System.out.println(".:保存操作日志  log saving()!");
    }
}
