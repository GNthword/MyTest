package com.milog.test.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Array;

/**
 * Created by miloway on 2018/6/14.
 */

public class AspectJTestActivity extends Activity {

    private final String TAG = "AspectJTestActivity";
    private TextView tvBase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aspectj_test_layout);

        init();
    }

    private void init() {
        Log.i(TAG, "init i");
        System.out.println("init sys");

        tvBase = (TextView) findViewById(R.id.tv_base);
        tvBase.setText("init");
    }
}
