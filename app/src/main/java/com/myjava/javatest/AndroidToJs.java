package com.myjava.javatest;

import android.webkit.JavascriptInterface;

public class AndroidToJs {
    @JavascriptInterface
    public void hello(String msg) {
        System.out.println(msg);
    }
}
