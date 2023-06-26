package com.example.lib2;

public class A {
    public void testA(int s, String... p) {
        System.out.println("A");
    }

    static {
        System.out.println("static");
    }

    {
        System.out.println("leui");
    }

    A() {
        System.out.println("A");
    }
}
