package com.milog.test.mytest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.milog.test.mytest.fm.FunctionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Created by miloway on 2018/6/5.
 */

public class FunctionManagerActivity extends Activity {

    private TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_test_layout);

        double a=  -1e-6 - 1;
        Class<?> cls = FunctionManager.class;

        tvShow = (TextView) findViewById(R.id.tv_show);
        tvShow.setText(getPath(this, findViewById(R.id.tv_path)));
        init();
    }

    private void init() {
        String function = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(getAssets().open("function.json"));
            byte[] b= new byte[bis.available()];
            bis.read(b);
            function = new String(b, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (function != null) {
            try {
                JSONObject object = new JSONObject(function);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String getPath(Context context, View childView) {
        StringBuilder builder = new StringBuilder();
        String viewType = childView.getClass().getSimpleName();
        View parentView = childView;
        int index;
        // 遍历view获取父view来进行拼接
        do {
            int id = childView.getId();
            index = ((ViewGroup) childView.getParent()).indexOfChild(childView);
            // 根据从属于不同的类进行index判断
//            if (childView.getParent() instanceof RecyclerView) {
//                index = ((RecyclerView) childView.getParent()).getChildAdapterPosition(childView);
//            } else
            if (childView.getParent() instanceof AdapterView) {
                index = ((AdapterView) childView.getParent()).getPositionForView(childView);
            } else if (childView.getParent() instanceof ViewPager) {
                index = ((ViewPager) childView.getParent()).getCurrentItem();
            }
            //builder.insert(0, getResourceId(context, childView.getId()));
            builder.insert(0, "]");
            builder.insert(0, index);
            builder.insert(0, "[");
            builder.insert(0, viewType);
            parentView = (ViewGroup) parentView.getParent();
            viewType = parentView.getClass().getSimpleName();
            childView = parentView;
            builder.insert(0, "/");
        } while (parentView.getParent() instanceof View);
        builder.insert(0, childView.getId());
        builder.insert(0, viewType);
        return builder.toString();
    }



}
