package com.study.br.api;


import com.study.br.bean.Recommend;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by adventurer on 17-1-7.
 */

public interface BookApiService {

    @GET("/book/recommend")
    Observable<Recommend> getRecomend(@Query("gender") String gender);


    Observable<LIst<BookSource>>


}
