package com.myjava.javatest;

class SystemUtils {
    public static int safeParseInt(String mEventCode) {
        try {
            return Integer.parseInt(mEventCode);
        } catch (Exception e) {

        }
        return 0;
    }
}
