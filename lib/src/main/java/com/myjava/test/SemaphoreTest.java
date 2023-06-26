package com.myjava.test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static Semaphore semaphore = new Semaphore(2);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    start();
                }
            }).start();
        }
    }

    private static void start() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ":doSomething start-");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":doSomething end-" );
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
