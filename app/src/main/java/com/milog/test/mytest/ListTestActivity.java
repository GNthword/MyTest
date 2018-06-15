package com.milog.test.mytest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miloway on 2018/2/26.
 */

public class ListTestActivity extends Activity {


    Button btnChange;
    LinearLayout llFixed;
    LinearLayout llContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_test_layout);
        btnChange = (Button) findViewById(R.id.btn_change);
        llFixed = (LinearLayout) findViewById(R.id.ll_fixed);
        llContent = (LinearLayout) findViewById(R.id.ll_content);
        initData();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) llContent.getChildAt(0);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv.getLayoutParams();
                params.width = 810;
                llContent.removeView(tv);
                llContent.addView(tv ,0, params);
            }
        });

        ArrayList<StockListItem> items = new ArrayList<StockListItem>(2);
        for (int i =0 ; i < 2; i ++) {
            StockListItem item = new StockListItem();
            item.valueList = new String[]{"index" + i,"item"};
            item.oldshijia = "shijia" + i;
            item.object = new StockListObject("object" + i);
            items.add(item);
        }
        ArrayList<StockListItem> items2 = new ArrayList<StockListItem>(2);
        for (int i =2 ; i < 4; i ++) {
            StockListItem item = new StockListItem();
            item.valueList = new String[]{"index" + i,"item"};
            item.oldshijia = "shijia" + i;
            item.object = new StockListObject("object" + i);
            items2.add(item);
        }
        ArrayList<StockListItem> clone = (ArrayList<StockListItem>) items.clone();

        for (StockListItem item : clone){
            Log.d("cc", item.oldshijia);
            Log.d("cc", item.valueList[0] + "   " + item.valueList[1]);
            Log.d("cc", item.object.object);
        }
        Log.d("cc", "===============================");
        for (int i =4 ; i < 6; i ++) {
            StockListItem item = new StockListItem();
            item.valueList = new String[]{"index" + i,"item"};
            item.oldshijia = "shijia" + i;
            item.object = new StockListObject("object" + i);
            items.add(item);
        }
        for (StockListItem item : items){
            Log.d("cc", item.oldshijia);
            Log.d("cc", item.valueList[0] + "   " + item.valueList[1]);
            Log.d("cc", item.object.object);
        }
        Log.d("cc", "===============================                                                                                                                        ");
        items = items2;
        for (StockListItem item : items){
            Log.d("cc", item.oldshijia);
            Log.d("cc", item.valueList[0] + "   " + item.valueList[1]);
            Log.d("cc", item.object.object);
        }
    }

    private void initData() {
        TextView tv = new TextView(this);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        tv.setText("fixed");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(270,150);
        llFixed.addView(tv,params);

        for (int i = 0; i < 5 ; i++){
            TextView tv1 = new TextView(this);
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
            tv1.setText("content" + i);
            tv1.setTextColor(Color.BLACK);
            tv1.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(270,150);
            llContent.addView(tv1,params1);
        }

    }


    private class StockListItem {
        public String[] valueList = null;
        public String oldshijia;
        public StockListObject object;
    }

    private class StockListObject {
        private String object;
        public StockListObject(String string){
            object = string;
        }
    }
}
