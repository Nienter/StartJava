package com.myjava.test;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("我是一只兰狗");
    }

    @Override
    public void run() {
        System.out.println("我跑的快");
    }
}
