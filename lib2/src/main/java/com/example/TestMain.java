package com.example;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMain {
    private final static ReentrantLock lock = new ReentrantLock(true);
    static int num = 23;

    public static void main(String[] args) {
//        TestMain t = new TestMain();
//        new Thread(TestMain::test, "1").start();
//        new Thread(TestMain::test, "2").start();
//        new Thread(TestMain::test, "3").start();
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str1.intern()));
        String str2 = "SEUCalvin";
        System.out.println(System.identityHashCode(str2));

//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//
//        System.out.println(str1 == "SEUCalvin");
    }


    public static void test() {
        String na = Thread.currentThread().getName();
//        lock.lock();
//        System.out.println(na);
//        lock.unlock();
        while (num > 1) {
            lock.lock();
            num--;
            System.out.printf("%s:%d%n", na, num);
            if (num < 1) {
                lock.unlock();
                break;
            }
            lock.unlock();
        }
    }

    static final byte[] DigitOnes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    };
}
