package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TheadTest {
    private volatile int num = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    public static void main(String[] args) {
        System.out.println(ctlOf(-1 << Integer.SIZE - 3, 0));
        lock.lock();
        CountDownLatch coun = new CountDownLatch(4);
        coun.countDown();
//        coun.await();
//        TheadTest test = new TheadTest();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.get();
//            }
//        });
//        t.start();
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.put();
//            }
//        });
//        t2.start();
//        t2.interrupt();
    }

    public void put() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        if (num > 0) {
            try {
                System.out.println("put await");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        condition.signal();
        lock.unlock();
    }

    public void get() {
        lock.lock();
        if (num == 0) {
            try {
                System.out.println("get await");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        condition.signal();
        lock.unlock();
    }
}
