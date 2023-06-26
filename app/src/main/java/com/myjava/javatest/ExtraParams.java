package com.myjava.javatest;

public class ExtraParams implements HttpBasePlugin {
    String string;

    public ExtraParams(String a) {
        this.string = a;
    }

    @Override
    public String addParams(String s) {
        return s + string;
    }
}
