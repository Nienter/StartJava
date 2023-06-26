package com.myjava.javatest;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;

public class MyBroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(Thread.currentThread());
//        Intent intent1 = new Intent(context, kAc.class);
//        context.startActivity(intent1);
//        AlertDialog.Builder builder = new AlertDialog.Builder(context.getApplicationContext());
//        AlertDialog dialog = builder.create();
        Dialog dialog = new Dialog(context);
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
        dialog.show();
    }
}
