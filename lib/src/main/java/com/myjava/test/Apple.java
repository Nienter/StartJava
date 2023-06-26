package com.myjava.test;

import java.io.Serializable;

public class Apple implements Serializable {
    private static final long serialVersionUID = 1900;
    private String name;
    private transient int age;
    private String gd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apple(String name, int age, String gd) {
        this.name = name;
        this.age = age;
        this.gd = gd;
    }

    public Apple() {

    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Apple(String name) {

    }

    public Apple(int age) {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
