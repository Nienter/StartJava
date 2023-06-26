package com.example.lib2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
//        Thread t0 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 26; i++) {
//                    lockTest.procudor();
//                }
//
//            }
//        });
////
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 3; i++) {
//
//                    lockTest.consumer();
//                }
//            }
//        });
//        t0.start();
////        Thread.sleep(1000);
//        t1.start();
////        Thread.sleep(1000);
//////        t1.interrupt();
////        ThreadLocal<Integer> local = new ThreadLocal<>();local.set(2);
////        local.get();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    System.out.println("dfdsg");
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.interrupt();
    }

    private int s = 1;

    public synchronized void procudor() {
        if (s > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        s++;
        System.out.println("product begin");
        notifyAll();
    }

    public synchronized void consumer() {
        if (s <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        s--;
        System.out.println("consumer begin");
        notifyAll();
    }


    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("inter" + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        String name = Thread.currentThread().getName();
        try {
//            lock.lock();
            lock.lockInterruptibly();
            System.out.println("methodB");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("inter" + Thread.currentThread().getName());
//            Thread.currentThread().interrupt();
        } finally {
            try {
                lock.unlock();
                System.out.println(name + "释放锁");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(name + " : 没有得到锁的线程运行结束");
            }
        }

    }
}
