package com.study.pg.http;

import com.study.pg.app.Constants;
import com.study.pg.app.MyApplication;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adventurer on 16-11-20.
 */

public class GirlsRetrofit {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            synchronized (GirlsRetrofit.class){
                if(retrofit == null){
                    retrofit  = new Retrofit.Builder()
                            .baseUrl(Constants.GANHUO_API)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(MyApplication.defaultOkHttpClient())
                            .build();
                }
            }
        }

        return retrofit;
    }

}
