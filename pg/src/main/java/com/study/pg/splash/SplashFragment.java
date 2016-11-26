package com.study.pg.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.study.pg.R;
import com.study.pg.base.ActivityManager;
import com.study.pg.base.BaseFragment;
import com.study.pg.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by adventurer on 16-11-20.
 */

public class SplashFragment extends BaseFragment implements SplashContract.View{
    @BindView(R.id.splash)
    ImageView iv_splash;

    private ScaleAnimation scaleAnimation;

    private Unbinder unbinder;
    private SplashPresenter mPresenter;


    public static SplashFragment getInstance() {
        SplashFragment splashFragment = new SplashFragment();
        return splashFragment;
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        mPresenter = new SplashPresenter(SplashFragment.this);
        initAnim();
    }

    private void initAnim() {
        scaleAnimation = new ScaleAnimation(1.0f,1.1f,1.0f,1.1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2500);
        iv_splash.startAnimation(scaleAnimation);

        //缩放动画监听
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
                ActivityManager.getInstance().finishActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    public void showGirl(String girlUrl) {
        Glide.with(getContext())
                .load(girlUrl)
                .animate(scaleAnimation)
                .into(iv_splash);

    }

    @Override
    public void showGirl() {
        Glide.with(getActivity())
                .load(R.mipmap.welcome)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .animate(scaleAnimation)
                .into(iv_splash);

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
