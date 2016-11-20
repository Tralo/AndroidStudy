package com.study.pg.splash;

import android.view.View;

import com.study.pg.R;
import com.study.pg.base.AppActivity;
import com.study.pg.base.BaseFragment;

/**
 * Created by adventurer on 16-11-20.
 */

public class SplashActivity extends AppActivity {
    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.splash_fragment;
    }

    @Override
    public void onClick(View view) {

    }
}
