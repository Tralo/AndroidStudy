package com.study.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class BaseActivity  extends AppCompatActivity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ButterKnife.bind(this);
        setupActivityComponent(AppApplication.getsInstance().getAppComponent());
    }
    protected abstract void setupActivityComponent(AppComponent appComponent);
    public abstract int getLayoutId() ;
}
