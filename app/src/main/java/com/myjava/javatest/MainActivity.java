package com.myjava.javatest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {
    private String string;
    private View view;
    private MyView myView;
    private static final String TAG = "MainActivity";
    public static String baseUrl = "http://www.baidu.com";
    private String Url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fj);
//        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, FirstActivity.class));
//            }
//        });
//
//
//        for (HttpBasePlugin s : MyApp.getManagers(HttpBasePlugin.class)) {
//            baseUrl = s.addParams(baseUrl);
//        }
//        Log.d(TAG, "onCreate: " + baseUrl);
//        TestRxJava();
    }

    private void TestRxJava() {
//        Observer<String> observer1 = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {//结束
//                Log.d(TAG, "onCompleted: ");
//            }
//
//            @Override
//            public void onError(Throwable e) {//错误
//                Log.d(TAG, "onError: ");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: ");
//            }
//
//            @Override
//            public void onStart() {
//                super.onStart();
//                Log.d(TAG, "onStart: ");
//            }
//        };
//
//        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onStart();
//                subscriber.onNext("hello");
//                subscriber.onNext("hi");
//                subscriber.onCompleted();
//            }
//        });
//        observable.subscribe(observer1);
//        Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: ");
//
//            }
//        };
//        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                Log.d(TAG, "call: ");
//            }
//        };
//        Action0 onCompleteAction = new Action0() {
//            @Override
//            public void call() {
//                Log.d(TAG, "call: complete");
//            }
//        };
//        observable.subscribe(onNextAction);
//        Action2<String, String> stringStringAction2 = new Action2<String, String>() {
//            @Override
//            public void call(String s, String s2) {
//
//            }
//        }
//        String[] names = new String[]{"wang","li","fu"};
//        Observable.from(names)
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d(TAG, "call: ");
//                    }
//                });
//        Observable.just(1, 2, 3, 4)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(integer -> Log.d(TAG, "call: " + integer));

    }

    @Subs(mode = mode.MAIN)
    public void test(Object o) {
        Method[] declaredMethods = MainActivity.class.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            declaredMethods[i].getAnnotation(Subs.class);
        }

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
    }

}
