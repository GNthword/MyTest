package com.milog.test.mytest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by miloway on 2018/9/20.
 */

public abstract class MyScrollView extends ScrollView {

    private int topHeight;


    public MyScrollView(Context context) {
        super(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        getTopHeight();
        if (t > topHeight) {
            showTopFixView();
        }else  {
            hideTopFixView();
        }
    }

    protected abstract void getTopHeight();

    protected abstract void hideTopFixView();

    protected abstract void showTopFixView();

    public void setTopHeight(int topHeight) {
        this.topHeight = topHeight;
    }
}
