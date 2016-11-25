package com.study.rxjava.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.study.rxjava.bean.Result;
import com.study.rxjava.bean.Story;
import com.study.rxjava.network.RetrofitManager;
import com.study.rxjava.network.VolleyManager;
import com.study.rxjava.network.inter.GetNews;
import com.study.rxjava.ui.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/25.
 */

public class MainPresenter implements MainContract.Presenter{

    private static final String TAG = "MainPresenter";


    private MainContract.View mView;
    private Context context;

    private GetNews getNews = RetrofitManager.getInstance().getRetrofit().create(GetNews.class);

    private List<Story> storyList;

    public MainPresenter(MainContract.View view,List<Story> storyList,Context context){
        this.mView = view;
        this.storyList = storyList;
        this.context = context;
    }


    @Override
    public void getDataByRetrofit() {
        mView.showProgressBar();
        Subscriber<Result> subscriber = new Subscriber<Result>() {

            @Override
            public void onStart() {
                super.onStart();
                storyList.clear();
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.hideProgressBar();
                mView.showErrorMeg(e.getMessage());
            }

            @Override
            public void onNext(Result result) {
                mView.hideProgressBar();
                storyList.addAll(result.getStories());
                Log.i(TAG,"返回数据:  " + result);
                mView.refreshAdapter();
            }
        };
        GetNews getNews = RetrofitManager.getInstance().getRetrofit().create(GetNews.class);
        getNews.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


    }

    @Override
    public void getDataByVolley() {
        mView.showProgressBar();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                RetrofitManager.BASE_URL + "latest",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        storyList.addAll(gson.fromJson(response,Result.class).getStories());
                        mView.refreshAdapter();
                        mView.hideProgressBar();
                        Log.i(TAG,"返回数据:  " + response);

                    }
                }, new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                        mView.showErrorMeg(error.getMessage());

                    }
                });;
        VolleyManager.getInstance().getRequestQueue(context.getApplicationContext()).add(stringRequest);

    }
}
