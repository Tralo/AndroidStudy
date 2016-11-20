package com.study.pg.data;

import com.study.pg.data.bean.GirlsBean;

/**
 * Created by adventurer on 16-11-20.
 */

public interface GirlsDataSource {

    interface LoadGirlsCallback{
        void onGirlsLoaded(GirlsBean girlsBean);

        void onDataNotAvailable();
    }

    void getGirls(int page,int size,LoadGirlsCallback callback);

    void getGirl(LoadGirlsCallback callback);

}
