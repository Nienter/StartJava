package com.example.lib2;

import java.io.IOException;
import java.time.Clock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {
    public static void main(String[] args) {
//        byte a = (byte) 128;
//        System.out.println(a);
        long i = 2l;
//        System.out.println("hjell"+i+i);
//        int b = ~-7;
//        System.out.println(b);
//        A a = new B();
//        a.testA(3,"eg","et");
//        B b = new B();
//        b.testA(3,new String[]{"gf","fdg"});
//        System.out.println(6==6.00);
//        A a = new A();
//        A bb = new A();
//        CacheImmutale a = CacheImmutale.valueOf("hello");
//        CacheImmutale b = CacheImmutale.valueOf("df");
//        System.out.println(a.equals(b));
//        ProcessArrat p = new ProcessArrat();
//        int[] ta = new int[]{4, 4, 4, 4, 4,};
//        p.process(ta, System.out::println);
//        Scanner scanner = new Scanner(System.in);
//        scanner.useDelimiter("\n");
//        while (scanner.hasNext()) {
//            System.out.println("输入的内容是" + scanner.next());
//        }
//        Runtime runtime = Runtime.getRuntime();
//        runtime.exec("notepad.exe");
//        String s = "Hello_java";
//        System.out.println(s.replaceFirst("\\w*", "kik"));
//        Pattern pattern = Pattern.compile("a*b");
//        Matcher matcher = pattern.matcher("aaaaaab");
//        System.out.println(matcher.matches());
//        NewRun newRun = new NewRun();
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                System.out.println("thread run");
//            }
//        };
//        thread.start();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return null;
//            }
//        });
//        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        float s = (float) 77 / 3;
        System.out.println(s);
    }

    public static class NewRun implements Runnable {

        @Override
        public void run() {
            System.out.println("runnable");
        }
    }
}