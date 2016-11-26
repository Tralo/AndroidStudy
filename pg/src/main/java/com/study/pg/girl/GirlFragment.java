package com.study.pg.girl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.study.pg.R;
import com.study.pg.base.BaseFragment;
import com.study.pg.data.bean.GirlsBean;
import com.study.pg.home.GirlsFragment;
import com.study.pg.widget.PinchImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by adventurer on 16-11-26.
 */

public class GirlFragment extends BaseFragment implements ViewPager.OnPageChangeListener{

    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.rootView)
    LinearLayout rootView;

    private GirlAdapter mAdapter;

    private ArrayList<GirlsBean.ResultsEntity> datas;

    private int current;
    private Unbinder unbinder;

    private OnGirlChange mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater,container,savedInstanceState);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    public static GirlsFragment newInstance(ArrayList<Parcelable> datas, int current){
        Bundle bundle = new Bundle();
        GirlsFragment fragment = new GirlsFragment();
        bundle.putParcelableArrayList("girls",datas);
        bundle.putInt("current",current);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mListener = (OnGirlChange) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this,view);
        Bundle bundle = getArguments();

        if(bundle != null){
            datas = bundle.getParcelableArrayList("girls");
            current = bundle.getInt("current");
        }
        mAdapter =  new GirlAdapter(mActivity,datas);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(current);
        mViewPager.setOnPageChangeListener(this);



    }




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_girl;
    }

    public interface OnGirlChange{
        void change(int color);
    }

    private PinchImageView getCurrentImageView(){
        View currentItem = mAdapter.getPrimaryItem();
        if(currentItem == null){
            return null;
        }
        PinchImageView imageView = (PinchImageView) currentItem.findViewById(R.id.img);
        if(imageView == null){
            return null;
        }

        return imageView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
