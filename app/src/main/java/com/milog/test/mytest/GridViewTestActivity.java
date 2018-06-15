package com.milog.test.mytest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miloway on 2018/2/27.
 */

public class GridViewTestActivity extends Activity {

    private GridView gridView;
    private ArrayList<GVData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_test_layout);

        gridView = (GridView) findViewById(R.id.grid_view);

        list= new ArrayList<GVData>(2);
        for (int i = 0; i < 2; i++) {
            GVData data = new GVData();
            if (i%2 == 0){
                data.text = "item" + i;
                data.type = true;
                data.resId = R.drawable.grid_folder_yellow;
            }else {
                data.type = false;
                data.resId = R.drawable.grid_folder_red;
            }
            list.add(data);
        }

        gridView.setAdapter(new MyAdapter(this));
    }



    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater ;

        public MyAdapter(Context context){
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
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
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (list.get(position).type) {
                return 1;
            }
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GVData data = list.get(position);
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                if (data.type) {
                    convertView = inflater.inflate(R.layout.gird_view_item1, null);
                }else {
                    convertView = inflater.inflate(R.layout.gird_view_item2, null);
                }
                viewHolder.tvItem = (TextView) convertView.findViewById(R.id.tv_item);
                viewHolder.ivBg = (ImageView) convertView.findViewById(R.id.iv_bg);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            convertView.setBackgroundColor(Color.WHITE);
            if (data.type){
                viewHolder.tvItem.setText(data.text);
            }
            viewHolder.ivBg.setImageResource(data.resId);
            return convertView;
        }

        private class ViewHolder {
            public TextView tvItem;
            public ImageView ivBg;
        }

    }

    private class GVData {
        private String text;
        private boolean type;
        private int resId;
    }

}
