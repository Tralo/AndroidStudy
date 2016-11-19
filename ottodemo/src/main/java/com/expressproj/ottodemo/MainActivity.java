package com.expressproj.ottodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusProvider.getInstance().register(this);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData data = new EventData();
                data.setContent("方式一:正在显示信息....");
                BusProvider.getInstance().post(data);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData data = new EventData();
                data.setContent("方式一:正在显示信息....");
                BusProvider.getInstance().post(data);
            }
        });
    }

    @Subscribe
    public void acceptEvent(EventData data){
        Toast.makeText(this,data.getContent(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    @Produce
    public EventData sendEventData(){
        EventData data = new EventData();
        data.setContent("方式222222222:正在显示信息....");
        return data;
    }
}
