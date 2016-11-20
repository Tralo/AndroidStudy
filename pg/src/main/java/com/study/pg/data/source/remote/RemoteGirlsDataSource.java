package com.study.pg.data.source.remote;

import com.study.pg.data.GirlsDataSource;
import com.study.pg.data.bean.GirlsBean;
import com.study.pg.http.GirlsRetrofit;
import com.study.pg.http.GirlsService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by adventurer on 16-11-20.
 */

public class RemoteGirlsDataSource implements GirlsDataSource{


    @Override
    public void getGirls(int page, int size, final LoadGirlsCallback callback) {
        GirlsRetrofit.getRetrofit()
                .create(GirlsService.class)
                .getGirls("福利",size,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlsBean>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(GirlsBean girlsBean) {
                        callback.onGirlsLoaded(girlsBean);
                    }
                });

    }

    @Override
    public void getGirl(LoadGirlsCallback callback) {
        getGirls(1, 1, callback);
    }
}
