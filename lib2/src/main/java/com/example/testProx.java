package com.example;

import java.lang.reflect.Proxy;

public class testProx {
    public static void main(String[] args) {
        ImplCar car = new ImplCar() {
            @Override
            public void setString() {
                System.out.println("degw");
            }
        };
        ImplCar proxy = (ImplCar) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), new DynamicProxy(car));
        proxy.setString();
    }
}
