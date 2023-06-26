package com.myjava.javatest.hello;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListView extends ListView {
    public MyListView(@NonNull Context context) {
        super(context);
    }

    public MyListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(500, // 设计一个较大的值和AT_MOST模式
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: ");
        return false;
    }

    private static final String TAG = "MyListView";
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
////            case MotionEvent.ACTION_DOWN:
////            case MotionEvent.ACTION_MOVE:
////                Log.d(TAG, "dispatchTouchEvent: "+event.getAction());
////                getParent().requestDisallowInterceptTouchEvent(true);
////                break;
////            case MotionEvent.ACTION_UP:
////            case MotionEvent.ACTION_CANCEL:
////                getParent().requestDisallowInterceptTouchEvent(false);
////                Log.d(TAG, "dispatchTouchEvent: "+event.getAction());
////                break;
//            default:
//                return true;
//        }
        Log.d(TAG, "dispatchTouchEvent: ");;
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    public static void main(String[] args) {
    }
}
