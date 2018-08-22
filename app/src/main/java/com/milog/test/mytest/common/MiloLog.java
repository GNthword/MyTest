package com.milog.test.mytest.common;

import android.nfc.Tag;
import android.util.Log;

/**
 * Created by miloway on 2018/8/22.
 */

public class MiloLog {


    public static void d(String tag, String msg) {
        Log.d(tag, msg);
        System.out.println(tag + " " + msg);
    }
}
