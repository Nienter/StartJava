package com.example.lib2.offer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    public static void main(String[] args) {
        //传入参数,是否为公平锁还是非公平锁
        Lock lock = new ReentrantLock(true);
        if (atomicBoolean.get()) {
            atomicBoolean.compareAndSet(false, true);
            atomicBoolean.set(false);
        }

    }
}
