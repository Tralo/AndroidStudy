package com.study.pg.http;


import com.study.pg.data.bean.GirlsBean;

import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by adventurer on 16-11-20.
 */

public interface GirlsService {
    @GET("api/data/{type}/{count}/{page}")
    Observable<GirlsBean> getGirls(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page

    );

}
