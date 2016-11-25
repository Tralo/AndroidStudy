package com.study.rxjava.network.inter;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface GetBitmap {

    @GET
    Observable<ResponseBody> getPicFromNet(@Url String url);

}
