package com.study.pg.home;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.study.pg.data.bean.GirlsBean;

/**
 * Created by adventurer on 16-11-25.
 */

public class GirlsAdapter extends RecyclerArrayAdapter<GirlsBean.ResultsEntity>{
    public GirlsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlsViewHolder(parent);
    }
}
