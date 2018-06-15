package com.milog.test.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by miloway on 2018/6/15.
 */

@EActivity
public class AndroidAnnotationTestActivity extends Activity {

    @ViewById(R.id.tv_show)
    TextView tvShow;

    @ViewById
    Button btnOk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa_test_layout);

    }


    @Click(R.id.btn_ok)
    void btnClick() {
        tvShow.setText("btn clicked");
    }

}
