package com.example.recyclerview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import adaper.NormalRecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rlv)
    RecyclerView rlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ButterKnife.bind(this);
    }

    private void initView() {
        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlv.setAdapter(new NormalRecyclerViewAdapter(this));

    }
}
