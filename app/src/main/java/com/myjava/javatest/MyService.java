package com.myjava.javatest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
//        startActivity(new Intent(getApplicationContext(), kAc.class));
        
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    private void methodInMyService() {
        System.out.println(Thread.currentThread().getName());
        Looper.prepare();
        Toast.makeText(getApplicationContext(), "服务里的方法执行了。。。",
                Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    private class MyBinder extends IMyBinder.Stub {
        @Override
        public void invokeMethodMyService() throws RemoteException {
            methodInMyService();
        }
    }
}
