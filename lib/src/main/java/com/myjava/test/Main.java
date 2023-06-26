package com.myjava.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int inputcount = 0;
        List<Integer> list = new ArrayList<>(a);
        while (sc.hasNext()&&inputcount<a){
            list.add(sc.nextInt());
        }
        System.out.println(list.toArray());
    }

    private static void test(String s) {
        String[] ss = s.split("\\s+");
        System.out.print(ss[ss.length - 1].length());
    }
}
