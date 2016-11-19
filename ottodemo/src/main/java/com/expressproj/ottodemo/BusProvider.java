package com.expressproj.ottodemo;

import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2016/11/18.
 */

public class BusProvider {

    private volatile static Bus bus = null;

    private BusProvider(){

    }

    public static Bus getInstance(){
        if(bus==null){
            synchronized (BusProvider.class) {  //加上sunchronized来防止并发

                bus=new Bus();
            }
        }
        return bus;
    }


}
