package com.niu.collection;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Lenovo on 2018/1/31.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //通过反射实例化对象
        Class c=Student.class;
        Object student =c.newInstance();
        Method method=getAttribute(student,"name");
        if(method!=null){
            //调用set方法 如果要得到get方法，过程类似
            method.invoke(student,"张珊珊");
        }else {
            System.out.println("该属性没有set方法");
        }
    }
    //通过一个对象得到一个类的属性信息
    public static Method getAttribute(Object bean, String name){
        //得到beanInfo 分析bean
        try {
            String[] result;
            BeanInfo beanInfo= Introspector.getBeanInfo(bean.getClass());
            //获取bean中的所有属性
            PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor pd:pds){

                System.out.print( pd.getPropertyType());
                if(pd.getName().equals(name)){
                   //得到set方法并返回
                    Method method=pd.getWriteMethod();
                    return method;
                }
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }
    //测试ArrayList集合
    public static void arrayListTest(){
        ArrayList<Student> students=new ArrayList<>();
        //添加元素
        students.add(new Student(1001,"张三丰","软件工程"));
        students.add(new Student(1001,"张三丰","软件工程"));
        students.add(new Student(1002,"风清扬","网络工程"));
        students.add(new Student(1003,"李书文","信息安全"));
        //遍历集合
        System.out.println("----------普通for循环遍历----------");
        for(int i=1;i<students.size();++i){
            System.out.println(students.get(i));
        }
        System.out.println("----------增强for循环遍历----------");
        for(Student student:students){
            System.out.println(student);
        }
        System.out.println("----------迭代器遍历----------");
        Iterator<Student> it=students.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //删除元素 根据索引删除
        System.out.println("----------索引删除第一个元素----------");
        students.remove(0);
        for(Student student:students){
            System.out.println(student);
        }
        //迭代器删除
        System.out.println("----------迭代器删除第一个元素----------");
        Iterator<Student> it2=students.iterator();
        if(it2.hasNext()){
            it2.next();
            it2.remove();
        }
        for(Student student:students){
            System.out.println(student);
        }
    }
    //测试LinkedList集合
    public static void linkedListTest(){
        LinkedList<Student> students=new LinkedList<>();

      }
    //
    public static void print(int index,Object object){
        System.out.println(index+": "+object.toString());
    }
}
/*
*             MethodDescriptor[] mds= beanInfo.getMethodDescriptors();
            for(MethodDescriptor md:mds){
                System.out.print(md.getName()+" ");
            }
* */