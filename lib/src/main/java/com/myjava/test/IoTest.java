package com.myjava.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IoTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("MyClass.java");
        byte[] b = new byte[1024];
        int hasread = 0;
        while (((hasread = inputStream.read(b)) > 0)) {
            System.out.println(new String(b, 0, hasread));
        }
        inputStream.close();
    }
}
