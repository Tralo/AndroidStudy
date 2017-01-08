package com.study.br.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.study.br.R;
import com.study.br.ReaderApplication;
import com.study.br.utils.StatusBarCompat;
import com.study.br.view.loading.CustomDialog;

import butterknife.ButterKnife;

/**
 * Created by adventurer on 16-11-28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar mCommonToolbar;

    protected Context mContext;
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    private boolean mNowMode;
    private CustomDialog dialog;//进度条

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if(statusBarColor == 0){
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        } else if(statusBarColor != -1){
            statusBarView = StatusBarCompat.compat(this,statusBarColor);
        }
        transparent19and20();
        mContext = this;
        ButterKnife.bind(this);
        setupActivityComponent(ReaderApplication.getsInstance().getAppComponent());



    }

    private void transparent19and20() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected void showStatusBar(){
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(statusBarColor);
        }
    }


    public abstract int getLayoutId();

    protected abstract void setupActivityComponent();

}
