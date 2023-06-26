package com.myjava.javatest.hello;

public class Nie {
    static {
        System.loadLibrary("nio");
    }

    public native String sayNie();
}
