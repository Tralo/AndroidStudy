package com.study.pg.about;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.ImageView;

import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.study.pg.BuildConfig;
import com.study.pg.R;
import com.study.pg.app.MyApplication;
import com.study.pg.base.BaseFragment;
import com.study.pg.base.GestureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by adventurer on 16-11-20.
 */

public class AboutActivity extends GestureActivity{

    @BindView(R.id.backdrop)
    ImageView mBackdrop;

    @BindView(R.id.about_toolbar)
    Toolbar mAboutToolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;


    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        mAboutToolbar.setTitle("关于我");
        setSupportActionBar(mAboutToolbar);
        mAboutToolbar.setNavigationIcon(R.mipmap.ic_back);
        mAboutToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
        //毛玻璃效果
        Glide.with(this)
                .load(MyApplication.currentGirl)
                .bitmapTransform(new BlurTransformation(this, 15))
                .into(mBackdrop);


    }

    @Override
    protected void doFinish() {
        finishActivity();
    }

    private void finishActivity() {
        finish();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_about;
    }

    @Override
    public void onClick(View view) {

    }
}
