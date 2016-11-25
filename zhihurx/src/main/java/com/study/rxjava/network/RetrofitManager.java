package com.study.rxjava.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/25.
 */

public class RetrofitManager {

    public static final String BASE_URL = "http://news-at.zhihu.com/api/4/news/";

    private Retrofit retrofit;
    private static RetrofitManager retrofitManager = new RetrofitManager();

    public static RetrofitManager getInstance(){
        return retrofitManager;
    }

    private RetrofitManager(){

    }

    public Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
