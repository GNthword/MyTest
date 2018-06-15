package com.milog.test.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = (TextView) findViewById(R.id.tv_status);

        findViewById(R.id.btn_layout_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NubiaLayoutTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_list_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_grid_view_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridViewTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_relative_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelativeTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_permission_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PermisstionTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_function_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FunctionManagerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_aspectj_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AspectJTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_aa_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AndroidAnnotationTestActivity_.class);
                startActivity(intent);
            }
        });

        if (Looper.myLooper() == Looper.getMainLooper()){
            tvStatus.setText("主线程");
        }else {
            tvStatus.setText("其他线程");
        }
    }
}
