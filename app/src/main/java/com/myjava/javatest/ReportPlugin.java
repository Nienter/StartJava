package com.myjava.javatest;

import android.util.Log;

import java.util.Collection;

public class ReportPlugin extends ActivityPlugin<BaseActivity> {

    private String mType;
    private String mId;

    public static void reportUser(BaseActivity activity, String type, String id) {
        Collection<ReportPlugin> rps = activity.getPlugins(ReportPlugin.class);
        Log.d(TAG, "reportUser: " + rps.size());
        for (ReportPlugin rp : rps) {
            rp.reportUser(type, id);
        }
    }

    @Override
    protected void onAttachActivity(BaseActivity activity) {
        super.onAttachActivity(activity);
    }

    public void reportUser(String type, String id) {
        this.mType = type;
        this.mId = id;
        showReportCauseDialog(type, id);
    }

    private static final String TAG = "ReportPlugin";


    private void showReportCauseDialog(String type, String id) {
        Log.e(TAG, "showReportCauseDialog: " + type + "**" + id);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
