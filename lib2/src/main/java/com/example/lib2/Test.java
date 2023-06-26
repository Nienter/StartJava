package com.example.lib2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test implements Runnable {

    @Override
    public void run() {
        try {
            test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test4(String name) {
        extractdfded(name);
    }

    private void extractdfded(String name) {
        extracted(name);
    }

    private void extracted(String name) {
        dffeg(name);
    }

    private void dffeg(String name) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
    }

    public void test() {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 2;
            }
        });
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void testee() {
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    class o{
        String v;
    }
    public static void main(String[] args) {
        new Test().test();

//        Test test = new Test();
//        test.test4(null);
//        Test test = new Test();
//        Thread thread1 = new Thread(test);
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    test.test3();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    test.test2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread1.start();
//        thread3.start();
//        thread2.start();
//        thread.interrupt();
//        Vector<Integer> vector = new Vector<>();
//        System.out.println(vector.capacity());
//        vector.add(1);
//        ArrayList<Integer> integers = new ArrayList<>();
//        System.out.println(integers.size());
//        HashMap<Integer,String> hash = new HashMap();
//        hash.put(3, "Dga");
//        String key = "dgasg";
//        int h = key.hashCode();
//        System.out.println(Integer.toBinaryString(h));
//        System.out.println(Integer.toBinaryString(h>>>16));
//        System.out.println(h);
//        System.out.println(key.hashCode() ^ (h >>> 16));
//        System.out.println(Integer.toBinaryString(key.hashCode() ^ (h >>> 16)));
//        int h = key.hashCode() ^ (h >>> 16);
//        int i =  2147483647;
//        int s = (int) Math.pow(2, 32);
//        System.out.println(i+i);
//       00000000 00000000 00000000 00000001 00000000 00000000 00000000 00000000
    }


    public synchronized void test1() throws InterruptedException {
        wait();
        System.out.println("1");
    }

    public synchronized void test3() throws InterruptedException {
        wait();
        System.out.println("2");
    }

    public synchronized void test2() throws InterruptedException {
        notifyAll();
    }
}
