package com.study.br;

import android.app.Application;

import com.study.br.base.CrashHandler;
import com.study.br.component.AppComponent;
import com.study.br.utils.AppUtils;

/**
 * Created by adventurer on 17-1-7.
 */

public class ReaderApplication extends Application{

    private static ReaderApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initComponent();
        AppUtils.init(this);
        CrashHandler.getInstance().init(this);
        initPrefs();
        initNightMode();

    }

    private void initComponent() {

    }

    public static ReaderApplication getsInstance(){
        return sInstance;
    }



}
