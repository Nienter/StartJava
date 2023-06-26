package com.myjava.test;

import java.util.HashSet;

public class MyHashSet {
    private String s;
    public MyHashSet(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
