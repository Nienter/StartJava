package com.example.lib2.offer;

public class JfTest {
    public static void main(String[] args) {
        JfTest jfTest = new JfTest();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                jfTest.set();
                System.out.println("1" + Thread.currentThread().getState());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                jfTest.set();
                System.out.println("2" + Thread.currentThread().getState());
            }
        });
        thread.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("3" + thread2.getState());
                }
            }
        }).start();
    }

    public  synchronized void set() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1111");
    }


}
