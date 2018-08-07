package com.milog.test.mytest.common;

import android.app.Dialog;
import android.content.Context;

import com.milog.test.mytest.R;

/**
 * Created by miloway on 2018/8/7.
 */

public class DialogFactory {

    public static Dialog getDialog(Context context, String content) {
        String title = "";
        String ok = "";
        String cancel = "";

        return getDialog(context, title, content, ok, cancel);
    }

    public static Dialog getDialog(Context context, String title, String content, String ok, String cancel) {
        Dialog dialog = new Dialog(context, R.style.MiDialog);



        return dialog;
    }
}
