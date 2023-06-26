package com.myjava.test;


import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Testsl {
    public static void main(String[] args) {


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100000; i++) {
//                    System.out.println(Thread.currentThread()+"**"+Thread.currentThread().isInterrupted());
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("hello");
//                        System.out.println(Thread.currentThread().getState());
//                        Lock lock = new ReentrantLock();
//                        try {
//                            lock.lockInterruptibly();
//                        } catch (InterruptedException e) {
//                            System.out.println(Thread.currentThread().isInterrupted());
//                            e.printStackTrace();
//                        }
//                        break;
//                    }
//                    System.out.println("fdsg");
//
//                }
//            }
//        });
//        thread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
//        String s = "dgadg";
//        System.out.println(new Testsl().strToInt(s));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
        }
    }
    public int strToInt(String str) {
        int number = 0;
        for (int i=0; i<str.length(); i++) {
            System.out.println(str.charAt(i)-'0');
            number *= 10;
            number += (str.charAt(i) - '0');
        }
        return number;
    }

    public static String m1(String str) {
//        if (TextUtils.isEmpty(str)) {
//            return "";
//        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        return String.valueOf(charArray);
    }

}
