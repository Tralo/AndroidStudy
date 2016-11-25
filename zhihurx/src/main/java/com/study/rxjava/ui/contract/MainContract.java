package com.study.rxjava.ui.contract;

import com.study.rxjava.base.BasePresenter;
import com.study.rxjava.base.BaseView;
import com.study.rxjava.bean.Story;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class MainContract {

    public interface View<Presenter> extends BaseView{
        void showProgressBar();
        void refreshAdapter();
        void hideProgressBar();
        void showErrorMeg(String msg);


    }

    public interface Presenter extends BasePresenter{

        void getDataByRetrofit();
        void getDataByVolley();

    }

}
