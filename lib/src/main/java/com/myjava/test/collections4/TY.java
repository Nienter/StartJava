package com.myjava.test.collections4;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

public class TY {
    public HashMap<String, Integer> tu = new HashMap<>();


    public static void main(String[] args) throws NoSuchFieldException {
        Class<TY> tyClass = TY.class;
        Field tu = tyClass.getDeclaredField("tu");
        Class<?> type = tu.getType();
        System.out.println(type);
        Type type1 = tu.getGenericType();
        System.out.println(type1);
    }

}
