package com.example.lib2;

import java.util.Objects;

/**
 * Immutale 缓存设计
 */
public class CacheImmutale {
    private static int MAX_SIZE = 10;
    private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];
    private static int pos = 0;
    private final String name;

    private CacheImmutale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmutale valueOf(String name) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        if (pos == MAX_SIZE) {
            cache[0] = new CacheImmutale(name);
            pos = 1;
        } else {
            cache[pos++] = new CacheImmutale(name);
        }
        return cache[pos - 1];
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CacheImmutale that = (CacheImmutale) o;
//        return Objects.equals(name, that.name);
//    }
    public boolean isEquals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return Objects.equals(name, ((CacheImmutale) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
