package com.milog.test.mytest.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.milog.test.mytest.R;

import java.util.ArrayList;

/**
 * Created by miloway on 2018/9/20.
 */

public class ScrollContainer extends RelativeLayout implements MiloScrollView.FixView{

    private ListView listView;


    public ScrollContainer(Context context) {
        super(context, null);
    }

    public ScrollContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {

        listView = (ListView) findViewById(R.id.list_view);

        ArrayList<String> list = new ArrayList<String>(50);
        for (int i = 0; i < 50; i++) {
            list.add("base " + i);
        }
        MyAdapter adapter = new MyAdapter();
        adapter.setData(list);

        listView.setAdapter(adapter);
    }

    @Override
    public void showFixView() {
        findViewById(R.id.ll_head2).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFixView() {
        findViewById(R.id.ll_head2).setVisibility(View.GONE);
    }


    private class MyAdapter extends BaseAdapter {
        private ArrayList<String> data;

        public void setData(ArrayList<String> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            if (data == null) {
                return 0;
            }
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if (convertView == null) {
                tv = new TextView(getContext());
            }else {
                tv = (TextView) convertView;
            }
            tv.setText(data.get(position));
            return tv;
        }
    }
}
