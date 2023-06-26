package com.myjava.test.collections4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokerHandler implements InvocationHandler {
    private Object targetC;

    public void setTarget(Object target) {
        targetC = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        kl();
        Object result = method.invoke(targetC, args);
        return result;
    }

    private void kl() {
        System.out.println("invoker");
    }


}
