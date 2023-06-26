package com.example.lib2.offer;

import java.util.Objects;

public class Person {
    private String name;
    public Person(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
   public static int i;
    public static void main(String[] args) {
        System.out.println(i);
    }
    static class ha{
         int p;
    }
}
