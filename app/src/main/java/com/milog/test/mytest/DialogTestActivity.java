package com.milog.test.mytest;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.milog.test.mytest.common.DialogFactory;
import com.milog.test.mytest.common.TypeSetTextView;

/**
 * Created by miloway on 2018/8/20.
 */

public class DialogTestActivity extends Activity {

    TypeSetTextView typeSetTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_test_layout);

        typeSetTextView = (TypeSetTextView) findViewById(R.id.tv_show);
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeSetTextView.setText("aaa测试");
//                showDialog();
            }
        });

    }



    private void showDialog() {
        final Dialog dialog = DialogFactory.getDialog(this, getResources().getString(R.string.privacy_statement));
        dialog.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
