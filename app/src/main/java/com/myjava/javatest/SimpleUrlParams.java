package com.myjava.javatest;

public class SimpleUrlParams implements HttpBasePlugin {
    private String baseUrl;

    public SimpleUrlParams(String s) {
        this.baseUrl = s;
    }

    @Override
    public String addParams(String s) {
        return s + baseUrl;
    }
}
