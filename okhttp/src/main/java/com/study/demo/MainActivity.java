package com.study.demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "taotao";

    private TextView tv_content;

    private String html_content;

    private OkHttpClient client = new OkHttpClient();

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            tv_content.setText(html_content);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content = (TextView) findViewById(R.id.tv_content);
//        demo_method1();
        demo_method2();
    }

    private void demo_method2() {
        Request req = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {


            }

            @Override
            public void onResponse(Response response) throws IOException {
                if(response.isSuccessful()){
                    //这里不是ui线程
                    Log.i(TAG,"response code: "+response.code());
                    html_content = response.body().string();
                    mHandler.sendEmptyMessage(0);
                }
            }
        });


    }


    private void demo_method1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request req = new Request.Builder()
                        .url("http://www.baidu.com").build();
                try {
                    Response response = client.newCall(req).execute();
                    if(response.isSuccessful()){
                        Log.i(TAG,"response code: "+response.code());
                        html_content = response.body().string();
                        mHandler.sendEmptyMessage(0);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }
}
