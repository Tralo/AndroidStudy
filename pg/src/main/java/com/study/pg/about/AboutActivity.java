package com.study.pg.about;

import android.view.View;

import com.study.pg.R;
import com.study.pg.base.BaseFragment;
import com.study.pg.base.GestureActivity;

/**
 * Created by adventurer on 16-11-20.
 */

public class AboutActivity extends GestureActivity{
    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void doFinish() {

    }

    private void finishActivity() {
        finish();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }

    @Override
    public void onClick(View view) {

    }
}
