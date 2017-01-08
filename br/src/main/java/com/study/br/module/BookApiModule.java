package com.study.br.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by adventurer on 17-1-7.
 */
@Module
public class BookApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient(){

    }


}
