package com.study.pg.home;

import com.study.pg.base.BasePresenter;
import com.study.pg.base.BaseView;
import com.study.pg.data.bean.GirlsBean;

import java.util.List;

/**
 * Created by adventurer on 16-11-25.
 */

public class GirlsContract {

    interface View extends BaseView{
        void refresh(List<GirlsBean.ResultsEntity> datas);

        void load(List<GirlsBean.ResultsEntity> datas);


        void showError();

        void showNormal();
    }

    interface Presenter extends BasePresenter{
        void getGirls(int page,int size,boolean isRefresh);
    }


}
