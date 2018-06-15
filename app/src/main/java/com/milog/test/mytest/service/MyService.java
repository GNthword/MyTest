package com.milog.test.mytest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by miloway on 2018/3/22.
 */

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
