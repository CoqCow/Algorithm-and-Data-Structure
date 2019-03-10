package com.niu.collection;

/**
 * Created by Lenovo on 2018/1/31.
 */
public class Student {
    private Integer number;
    private String name;
    private String major;
    public Student(){

    }
    public Student(Integer number, String name, String major) {
        this.number = number;
        this.name = name;
        this.major = major;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "这个Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
