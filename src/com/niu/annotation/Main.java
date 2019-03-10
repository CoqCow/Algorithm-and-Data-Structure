package com.niu.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setNickname("软风秦");
        user.setEmail("123211515df");
        Class<?> userClass = user.getClass();
        boolean hasTableName = userClass.isAnnotationPresent(Table.class);
        if (!hasTableName) return;
        Table table = userClass.getAnnotation(Table.class);
        System.out.println(table.value());
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            boolean hasColumn = field.isAnnotationPresent(Column.class);
            if (!hasColumn) return;
            Column column = field.getAnnotation(Column.class);
            String methodName="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            Method method=userClass.getMethod(methodName);
            Object value=method.invoke(user);

            System.out.println(column.value()+"="+value);
        }
    }
}
