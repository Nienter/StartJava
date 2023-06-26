package com.myjava.javatest;

import android.app.Application;
import android.util.Log;

import java.util.Collection;

public class MyApp extends Application {
    private static final String TAG = "MyAPp";
    private static PluginHelper<AppBaseListener> pluginHelper = new SyncPluginHelper<AppBaseListener>();
    public static Application my;

    @Override
    public void onCreate() {
        super.onCreate();
        my = this;

        Log.d(TAG, "queueIdle: ");
//                registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//                    @Override
//                    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
//                        Log.d(TAG, "onActivityCreated: "+activity);
//                    }
//
//                    @Override
//                    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
//
//                    }
//
//                    @Override
//                    public void onActivityStarted(@NonNull Activity activity) {
//                        Log.d(TAG, "onActivityStarted: "+activity);
//                    }
//
//                    @Override
//                    public void onActivityResumed(@NonNull Activity activity) {
//                        Log.d(TAG, "onActivityResumed: "+activity);
//                    }
//
//                    @Override
//                    public void onActivityPaused(@NonNull Activity activity) {
//                        Log.d(TAG, "onActivityPaused: "+activity);
//                    }
//
//                    @Override
//                    public void onActivityStopped(@NonNull Activity activity) {
//                        Log.d(TAG, "onActivityStopped: "+activity);
//                    }
//
//                    @Override
//                    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
//                        Log.d(TAG, "onActivitySaveInstanceState: "+activity);
//                    }
//
//                    @Override
//                    public void onActivityDestroyed(@NonNull Activity activity) {
//                        Log.d(TAG, "onActivityDestroyed: "+activity);
//                    }
//                });

//        pluginHelper.addManager(new SimpleUrlParams("simple"));
//        pluginHelper.addManager(new ExtraParams("extra"));
//        Cockroach.install(new Cockroach.ExceptionHandler() {
//
//            // handlerException内部建议手动try{  你的异常处理逻辑  }catch(Throwable e){ } ，以防handlerException内部再次抛出异常，导致循环调用handlerException
//
//            @Override
//            public void handlerException(final Thread thread, final Throwable throwable) {
//                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Log.d("Cockroach", thread + "\n" + throwable.toString());
//                            throwable.printStackTrace();
//                            Toast.makeText(MyApp.this, "Exception Happend\n" + thread + "\n" + throwable.toString(), Toast.LENGTH_SHORT).show();
////                        throw new RuntimeException("..."+(i++));
//                        } catch (Throwable e) {
//
//                        }
//                    }
//                });
//            }
//        });
//        new Handler(Looper.getMainLooper()).post(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Looper.loop();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
    }


    public static <T extends AppBaseListener> Collection<T> getManagers(
            Class<T> cls) {
        return pluginHelper.getManagers(cls);
    }

    public static Application getInstance() {
        return my;
    }
}
