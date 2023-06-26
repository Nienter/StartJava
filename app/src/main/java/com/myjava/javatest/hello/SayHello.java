package com.myjava.javatest.hello;

import android.util.Log;

public class SayHello {
    static {
        System.loadLibrary("hello");
    }

    public static native String sayHello();

    public static native int sum(int a, int b);

    public static native void callSuperInstanceMethod();

    public static native int[] operateIntArray();

    public static native String[] operateStringArray();

    public static native Person[] operateObjectArray();

    public static native void nativeInit();

    //供JNI端回调的Java方法
    public static void onNativeCallBack(int count) {
        Log.e("SayHello", "onNativeCallBack : " + count);
    }

    public static native void throwException() throws IllegalArgumentException;

    public static void callBack() throws NullPointerException {
        throw new NullPointerException("null");
    }

    public static String getString(int s, String a) {
        return "";
    }


    public static int test(int a) {
        return a;
    }

}
