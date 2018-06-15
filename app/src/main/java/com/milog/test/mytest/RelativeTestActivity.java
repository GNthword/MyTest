package com.milog.test.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by miloway on 2018/3/12.
 */

public class RelativeTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gird_view_item1);
        findViewById(R.id.tv_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
