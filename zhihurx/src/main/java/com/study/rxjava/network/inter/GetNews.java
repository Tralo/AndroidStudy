package com.study.rxjava.network.inter;

import com.study.rxjava.bean.Result;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface GetNews {

    @GET("latest")
    Observable<Result>  getNews();

}
