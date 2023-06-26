package com.myjava.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtils du = new DogUtils();
        du.method1();
        Object result = method.invoke(target, args);
        du.method2();

        return result;
    }
}
