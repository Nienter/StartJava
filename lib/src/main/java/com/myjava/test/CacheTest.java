package com.myjava.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CacheTest {
    final Object fileObject = new Object();
    static File file = new File("ui.txt");
    public static void main(String[] args) throws FileNotFoundException {

        CacheTest cacheTest = new CacheTest();
        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cacheTest.writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cacheTest.readFile();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }


    public void writeFile() throws IOException {
        synchronized (fileObject) {
            System.out.println("write");
            FileOutputStream fileOutputStreams = new FileOutputStream(file);
            try (ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStreams)) {
                List<Apple> apples = new ArrayList<>();
                Apple apple = new Apple("sdfadd", 1, "gf");
//                Apple apple2 = new Apple("sfdd", 1, "gf");
                apples.add(apple);
//                apples.add(apple2);
                outputStream.writeObject(apples);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile() throws FileNotFoundException {
        synchronized (fileObject) {
            System.out.println("read");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try (ObjectInputStream inputStream = new ObjectInputStream(fileInputStream2)) {
                List<Apple> apple = (List<Apple>) inputStream.readObject();
                System.out.println(apple.get(0).getName());
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
