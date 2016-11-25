package com.study.pg.home;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.study.pg.R;
import com.study.pg.data.bean.GirlsBean;

/**
 * Created by adventurer on 16-11-25.
 */

public class GirlsViewHolder extends BaseViewHolder<GirlsBean.ResultsEntity> {

    private ImageView image;


    public GirlsViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_girl);
        image = $(R.id.girl_img);
    }

    @Override
    public void setData(GirlsBean.ResultsEntity data) {
        super.setData(data);
        Glide.with(getContext())
                .load(data.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);



    }
}
