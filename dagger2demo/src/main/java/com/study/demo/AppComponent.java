package com.study.demo;

import dagger.Component;

/**
 * Created by Administrator on 2016/11/24.
 */

@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {

    void inject(ReposListActivity activity);

}
