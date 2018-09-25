package com.milog.test.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miloway on 2018/9/20.
 */

public class NestedScrollViewTestActivity extends Activity {

    private NestedScrollView nestedScrollView;
    private TextView tvTop;
    private TextView tvNavigation;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_scroll_test_layout);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        tvTop = (TextView) findViewById(R.id.tv_top);
        tvNavigation = (TextView) findViewById(R.id.tv_navigation);
        recyclerView = (RecyclerView) findViewById(R.id.list_view);


        init();
        initData();
    }

    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        nestedScrollView.setNestedScrollingEnabled(true);
    }

    private void initData() {
        ArrayList<String> strings = new ArrayList<>(40);
        for (int i = 0; i < 40; i++) {
            strings.add("base " + i);
        }
        adapter.setData(strings);
        adapter.notifyDataSetChanged();
    }













    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        public void setData(ArrayList<String> data) {
            this.data = data;
        }

        ArrayList<String> data;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
            return new MyViewHolder(item);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(data.get(position));

        }

        @Override
        public int getItemCount() {
            if (data == null) {
                return 0;
            }
            return data.size();
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

}
