package com.study.pg.splash;

import com.study.pg.app.MyApplication;
import com.study.pg.data.bean.GirlsBean;
import com.study.pg.data.source.GirlsResponsitory;

/**
 * Created by adventurer on 16-11-20.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;
    private GirlsResponsitory mResponsitory;

    public SplashPresenter(SplashContract.View view){
        mView = view;
        mResponsitory = new GirlsResponsitory();
    }


    @Override
    public void start() {
        mResponsitory.getGirl(new GirlsResponsitory.LoadGirlsCallback() {
            @Override
            public void onGirlsLoaded(GirlsBean girlsBean) {
                mView.showGirl(girlsBean.getResults().get(0).getUrl());
                MyApplication.currentGirl = girlsBean.getResults().get(0).getUrl();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showGirl();
            }
        });

    }
}
