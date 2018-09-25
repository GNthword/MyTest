package com.milog.test.mytest.view;

import android.content.Context;
import android.util.AttributeSet;

import com.milog.test.mytest.R;

/**
 * Created by miloway on 2018/9/25.
 */

public class MiloScrollView extends MyScrollView {

    int[] pos;
    int y;
    public MiloScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getTopHeight() {
        if (y == 0) {
            y = findViewById(R.id.ll_bottom).getTop();
            setTopHeight(y);
        }
    }

    @Override
    protected void hideTopFixView() {
        if (getParent() instanceof FixView) {
            ((FixView)getParent()).hideFixView();
        }
    }

    @Override
    protected void showTopFixView() {
        if (getParent() instanceof FixView) {
            ((FixView)getParent()).showFixView();
        }
    }

    public interface FixView {
        public void showFixView();

        public void hideFixView();
    }
}
