package com.myjava.recy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyRecycleView extends ViewGroup {
    private boolean isNeedLayout;
    private List<View> viewList;
    private AdApter adApter;
    int rowCounts;
    private int[] height;


    public MyRecycleView(Context context) {
        super(context);
    }

    public MyRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        isNeedLayout = true;
    }

    public void setAdapter(AdApter adapter) {
        this.adApter = adapter;
        isNeedLayout = true;
    }

    public MyRecycleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyRecycleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
   //非常耗时
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isNeedLayout || changed) {
            isNeedLayout = false;
            viewList.clear();
            removeAllViews();
            if(adApter!=null){
                rowCounts = adApter.getCount();
            }
            for (int i = 0; i < adApter.getCount(); i++) {
                height[i]+= adApter.getHeight(i);
            }
        }
        SparseArray<String> s = new SparseArray<>();
    }

    interface AdApter {
        View OnCreateViewHolder(int position, View converView, ViewGroup viewGroup);

        View OnBindViewHolder(int position, View converView, ViewGroup viewGroup);

        int getItemViewType(int row);

        int getViewTypeCount();

        int getCount();

        int getHeight(int i);
    }
}
