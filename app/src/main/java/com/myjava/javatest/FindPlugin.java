package com.myjava.javatest;

import android.util.Log;

public class FindPlugin extends ReportPlugin {
    private static final String TAG = "FindPlugin";

    @Override
    public void reportUser(String type, String id) {
        Log.d(TAG, "reportUser: ");
    }
}
