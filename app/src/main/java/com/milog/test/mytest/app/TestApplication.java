package com.milog.test.mytest.app;

import android.app.Application;

/**
 * Created by miloway on 2018/3/22.
 */

public class TestApplication extends Application {

    private static TestApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static TestApplication getApplication() {
        return application;
    }

}
