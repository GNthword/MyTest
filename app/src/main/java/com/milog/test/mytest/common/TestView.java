package com.milog.test.mytest.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by miloway on 2018/3/22.
 */

public class TestView extends LinearLayout {

    private MyHandler handler;
    private MyHandler2 handler2;

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler = new MyHandler();
        handler2 = new MyHandler2();
        handler.sendEmptyMessage(1);
        handler2.sendEmptyMessage(1);

    }

    class MyHandler extends Handler {
        MyHandler(){
            super(Looper.getMainLooper());
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    class MyHandler2 extends Handler {
        MyHandler2(){

        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
}
