package com.myjava.javatest;

public class Mn {
    static {
        System.loadLibrary("MN");
    }
    public native void sayHello();
}
