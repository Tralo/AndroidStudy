package com.study.rxjava.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/11/25.
 */

public class VolleyManager {

    private RequestQueue requestQueue;

    private static VolleyManager volleyManager = new VolleyManager();

    public static VolleyManager getInstance(){
        return volleyManager;
    }

    private VolleyManager(){
    }

    public RequestQueue getRequestQueue(Context context){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }

        return  requestQueue;
    }

}
