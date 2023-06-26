package com.myjava.javatest;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class EnumTest {
    public void judge(SeasonSum seasonSum) {
        switch (seasonSum) {
            case Fall:
                break;
            case Spring:
                break;
            case Summer:
                break;
            case Winner:
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SeasonSum seasonSum = Enum.valueOf(SeasonSum.class, "Spring");
        seasonSum.setName("sdf");
        CountDownLatch countDownLatch = new CountDownLatch(5);
        try {
            Objects.requireNonNull(countDownLatch);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
