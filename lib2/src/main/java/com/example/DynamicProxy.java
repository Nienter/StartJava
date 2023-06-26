package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private ImplCar buyCar;

    public DynamicProxy(ImplCar buyCar) {
        this.buyCar = buyCar;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(buyCar, args);
        System.out.println("eeeeee");
        return result;
    }
}
