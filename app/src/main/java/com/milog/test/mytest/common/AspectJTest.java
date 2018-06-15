package com.milog.test.mytest.common;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by miloway on 2018/6/14.
 */
@Aspect
public class AspectJTest {
    private final String TAG = "AspectJTest";

//    @Before("execution(* com.milog.test.mytest.AspectJTestActivity.init())")
    public void before() {
        Log.i(TAG, "before");
    }


    public void after() {
        Log.i(TAG, "after");
    }

    @Around("execution(* com.milog.test.mytest.AspectJTestActivity.init())")
    public void around(JoinPoint joinPoint) {
        Log.i(TAG, "around" + joinPoint.toString());
        Log.i(TAG, "around" + joinPoint.toLongString());
        Log.i(TAG, "around" + joinPoint.toShortString());

    }

    @AfterReturning()
    public void afterClick() {

    }




}
