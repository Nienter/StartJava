package com.myjava.test;

import java.util.HashSet;
import java.util.Iterator;

public class MyTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new MyHashSet("fdsf"));
        hashSet.add(new MyHashSet("gfghh"));
        Iterator iterator = hashSet.iterator();
        iterator.forEachRemaining(obj -> System.out.println(obj.hashCode())) ;
    }
}
