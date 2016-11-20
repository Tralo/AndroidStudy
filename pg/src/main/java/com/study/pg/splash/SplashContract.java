package com.study.pg.splash;

import com.study.pg.base.BasePresenter;
import com.study.pg.base.BaseView;

/**
 * Created by adventurer on 16-11-20.
 */

public interface SplashContract {


    interface View extends BaseView<Presenter>{
        void showGirl(String girlUrl);

        void showGirl();
    }

    interface Presenter extends BasePresenter{

    }

}
