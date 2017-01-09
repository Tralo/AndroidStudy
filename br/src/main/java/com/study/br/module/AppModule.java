package com.study.br.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adventurer on 17-1-7.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

}
