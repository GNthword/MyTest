package com.milog.test.mytest.common;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.milog.test.mytest.R;
import com.milog.test.mytest.app.TestApplication;

/**
 * Created by miloway on 2018/8/7.
 */

public class DialogFactory {



    public static Dialog getDialog(Context context, String content) {
        if (context == null) {
            context = TestApplication.getApplication();
        }
        String title = "tip";
        String ok = context.getResources().getString(R.string.btn_ok);
        String cancel = context.getResources().getString(R.string.btn_cancel);

        return getDialog(context, title, content, ok, cancel);
    }

    public static Dialog getDialog(Context context, String title, String content, String ok, String cancel) {
        if (context == null) {
            context = TestApplication.getApplication();
        }
        Dialog dialog = new Dialog(context, R.style.MiDialog);
        View contentView = LayoutInflater.from(context).inflate(R.layout.milo_dialog, null);
        TextView tvTitle = (TextView) contentView.findViewById(R.id.tv_title);
        TextView tvContent = (TextView) contentView.findViewById(R.id.tv_content);
        Button btnCancel = (Button) contentView.findViewById(R.id.btn_cancel);
        Button btnOk = (Button) contentView.findViewById(R.id.btn_ok);

        tvTitle.setText(title);
        tvContent.setText(content);
        btnCancel.setText(cancel);
        btnOk.setText(ok);

        //init theme

        dialog.setContentView(contentView);
        return dialog;
    }
}
