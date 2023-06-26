package com.myjava.test;

import java.util.concurrent.CountDownLatch;

public class Countdown {
    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("eat");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    downLatch.countDown();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("drink");

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }finally {
                    downLatch.countDown();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("sleep");

                } catch (InterruptedException e) {
                    downLatch.countDown();
                    e.printStackTrace();
                }
                finally {
                    downLatch.countDown();
                }
            }
        }).start();

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("success");
    }
}
