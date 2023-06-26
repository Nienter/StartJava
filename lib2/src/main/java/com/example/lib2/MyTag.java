package com.example.lib2;

import java.lang.annotation.Target;

@Target(java.lang.annotation.ElementType.TYPE)

public @interface MyTag {
    String name() default "ff";

    int age() default 35;
}
