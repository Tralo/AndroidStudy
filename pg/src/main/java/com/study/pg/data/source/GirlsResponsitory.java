package com.study.pg.data.source;

import com.study.pg.data.GirlsDataSource;
import com.study.pg.data.source.local.LocalGirlsDataSource;
import com.study.pg.data.source.remote.RemoteGirlsDataSource;

/**
 * Created by adventurer on 16-11-20.
 */

public class GirlsResponsitory implements GirlsDataSource {

    private LocalGirlsDataSource mLocalGirlsDataSource;
    private RemoteGirlsDataSource mRemoteGirlsDataSource;

    public GirlsResponsitory(){
        mLocalGirlsDataSource = new LocalGirlsDataSource();
        mRemoteGirlsDataSource = new RemoteGirlsDataSource();
    }

    @Override
    public void getGirls(int page, int size, LoadGirlsCallback callback) {
        mRemoteGirlsDataSource.getGirls(page, size, callback);
    }

    @Override
    public void getGirl(LoadGirlsCallback callback) {
        mRemoteGirlsDataSource.getGirl(callback);
    }
}
