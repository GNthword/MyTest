package com.milog.test.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.milog.test.mytest.common.Browser;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by miloway on 2018/8/1.
 */

public class WebViewTestActivity extends Activity {

    private ArrayList<String> files;
    private int index;
    private Browser webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_test_layout);

        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
        webView = (Browser) findViewById(R.id.web_view);

        init();
        change();
    }

    private void init() {
        files = new ArrayList<String>(3);
        files.add("1.htm");
        files.add("2.htm");
        files.add("3.htm");
        index = 0;
    }

    private void change() {
        if (++index == 3) {
            index = 0;
        }

        String string = getStringFromAssets();

        webView.loadDataWithBaseURL(null, string, "text/html", "GBK", null);
    }

    public String getStringFromAssets() {
        InputStream is = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = null;
        try {
            is = getAssets().open(files.get(index));
            bis = new BufferedInputStream(is);
            bos = new ByteArrayOutputStream(is.available());
            byte[] bytes = new byte[1024];
            while (bis.read(bytes) != -1) {
                bos.write(bytes);
            }
            bos.flush();

            return new String(bos.toByteArray(), "GBK");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


        return null;
    }
}
