package com.study.pg.girl;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.study.pg.R;
import com.study.pg.data.bean.GirlsBean;
import com.study.pg.splash.SplashContract;
import com.study.pg.widget.PinchImageView;

import java.util.ArrayList;

/**
 * Created by adventurer on 16-11-26.
 */

public class GirlAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<GirlsBean.ResultsEntity> mDatas;
    private LayoutInflater layoutInflater;
    private View mCurrentView;

    public GirlAdapter(Context context,ArrayList<GirlsBean.ResultsEntity> datas){
        mContext = context;
        mDatas = datas;
        layoutInflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentView = (View) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        String imageUrl = mDatas.get(position).getUrl();
        View view = layoutInflater.inflate(R.layout.item_girl_detail,container,false);
        PinchImageView imageView = (PinchImageView)view.findViewById(R.id.img);
        Glide.with(mContext)
                .load(imageUrl)
                .thumbnail(0.2f)
                .into(imageView);
        container.addView(view);

        return view;
    }
    public View getPrimaryItem() {
        return mCurrentView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
