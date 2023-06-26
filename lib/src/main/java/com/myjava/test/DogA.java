package com.myjava.test;

import com.myjava.test.collections4.Animal;
import com.myjava.test.collections4.MyInvokerHandler;

import java.lang.reflect.Proxy;

public class DogA implements Animal {
    public void run() {
        System.out.println("run");
    }

    public void walk() {
        System.out.println("walk");
    }


    public static void main(String[] args) {
        MyInvokerHandler handler = new MyInvokerHandler();
        Animal dog = new DogA();
        handler.setTarget(dog);
        Animal animal = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), handler);
        animal.walk();
    }

    public static void kl() {
        System.out.println("invoke method");
    }
}
