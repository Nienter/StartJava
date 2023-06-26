package com.example.lib2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;

public class IoTest {
    public static void main(String[] args) throws IOException {
        Single.create((SingleOnSubscribe<Integer>) it -> {
                    foo(it);
                }
        ).timeout(1, TimeUnit.SECONDS, Single.just(0))
                .subscribe(it -> {
                    if (it == 0) {
                        System.out.println("dgdgdg");
                    } else if (it == 1) {
                        System.out.println(11);
                    }
                });

    }

    private static void foo(SingleEmitter<Integer> it) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dbfgfgg");
        it.onSuccess(1);
    }

}
