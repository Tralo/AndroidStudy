package com.study.br.module;

import com.study.br.api.support.LoggingInterceptor;
import com.study.br.base.Constant;

import dagger.Module;
import dagger.Provides;
import okhttp3.Connection;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adventurer on 17-1-7.
 */
@Module
public class BookApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient(){
        LoggingInterceptor logging = new LoggingInterceptor(new MyLog());


    }

    public static class MyLog implements LoggingInterceptor.Logger{

        @Override
        public void log(String message) {
            LogUtils.i("oklog: " + message);
        }
    }


}
