package com.myjava.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Book {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
    public Book(){

    }
    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Book> bookClass = Book.class;
        Field[] fields = bookClass.getFields();//获取public成员变量
        Field[] declaredFields = bookClass.getDeclaredFields();//不管修饰符,只获取本类声明的所有的成员变量
        for (Field field : declaredFields) {
            System.out.println(field.getName());//获取public
        }
        Field name = bookClass.getDeclaredField("name");
//        bookClass.getDeclaredField()
        name.setAccessible(true);
        Book book = bookClass.newInstance();
        name.set(book,"fdsf");
        System.out.println(book);

        Method[] methods = bookClass.getMethods();//获取所有public方法，包括继承来的
        Method[] declaredMethods = bookClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
        //为了避免方法重载，因为形参不同，所以要要有一个参数的类对象，并且是可变长的
        Method setName = bookClass.getMethod("setName", String.class);
//        bookClass.getDeclaredMethod("getId", int.class);
        setName.invoke(book, "Fdfd");
        System.out.println(book);


        //获取构造器，
        Constructor<?>[] constructors = bookClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());

        }
        Constructor<Book> constructor = bookClass.getConstructor( int.class,String.class);
        Book dsg = constructor.newInstance(12, "dsg");
        System.out.println(dsg);

    }
}
