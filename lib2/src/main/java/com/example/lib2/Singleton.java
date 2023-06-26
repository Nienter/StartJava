package com.example.lib2;

public class Singleton {
    private static Singleton singleonIns;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleonIns == null) {
            return singleonIns = new Singleton();
        }
        return singleonIns;
    }

}
