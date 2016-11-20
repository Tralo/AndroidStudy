package com.study.pg.home;

import android.view.View;

import com.study.pg.base.AppActivity;
import com.study.pg.base.BaseFragment;

/**
 * Created by adventurer on 16-11-20.
 */

public class HomeActivity extends AppActivity{

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public void onClick(View view) {

    }
}
