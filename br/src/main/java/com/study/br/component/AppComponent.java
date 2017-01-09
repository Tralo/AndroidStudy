package com.study.br.component;

import android.content.Context;

import com.study.br.api.BookApi;
import com.study.br.module.AppModule;
import com.study.br.module.BookApiModule;

import dagger.Component;

/**
 * Created by adventurer on 17-1-9.
 */

@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {

    Context getContext();

    BookApi getReaderApi();

}
