package com.study.br.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toolbar;

import com.study.br.view.loading.CustomDialog;

/**
 * Created by adventurer on 16-11-28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar mCommonToolbar;

    protected Context mContext;
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    private boolean mNowMode;
    private CustomDialog dialog;

}
