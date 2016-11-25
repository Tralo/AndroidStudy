package com.study.demo;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/11/24.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;

    }

    @Provides
    public Application provideApplication(){
        return application;
    }

}
