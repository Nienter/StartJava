package com.example.lib2.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {
    private static AtomicInteger a = new AtomicInteger(10);
    private final static Object object = new Object();
    static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        vector.add(null);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a.get());
                boolean s = a.compareAndSet(10, 11);
                System.out.println(Thread.currentThread().getName()+s);
                System.out.println(a.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean s = a.compareAndSet(10, 11);
                System.out.println(s);
                System.out.println(Thread.currentThread().getName()+s);
                System.out.println(a.get());

            }
        });
//        Collections.synchronizedCollection()
        thread.start();

        thread2.start();
    }
    public void t(){
            synchronized (object){

        }
    }
}

