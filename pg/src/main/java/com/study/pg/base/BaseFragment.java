package com.study.pg.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by adventurer on 16-11-19.
 */

public abstract class BaseFragment extends Fragment{


    protected BaseActivity mActivity;

    protected abstract void initView(View view, Bundle savedInstanceState);


    //获取fragment布局文件ID
    protected abstract int getLayoutId();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    //获取宿主Activity
    protected BaseActivity getHoldingActivity(){
        return mActivity;
    };

    //添加fragment
    protected void addFragment(BaseFragment fragment){
        if(null != fragment){
            getHoldingActivity().addFragment(fragment);
        }
    }


    //移除fragment
    protected void removeFragment(){
        getHoldingActivity().removeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(),container,false);
        initView(view,savedInstanceState);
        return view;
    }
}
