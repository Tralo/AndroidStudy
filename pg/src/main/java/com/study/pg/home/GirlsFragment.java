package com.study.pg.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.study.pg.base.BaseFragment;
import com.study.pg.data.bean.GirlsBean;

import java.util.List;

import butterknife.BindView;

/**
 * Created by adventurer on 16-11-25.
 */

public class GirlsFragment extends BaseFragment implements GirlsContract.View, SwipeRefreshLayout.OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener {
    public static final String TAG = "GirlsFragment";





    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void refresh(List<GirlsBean.ResultsEntity> datas) {

    }

    @Override
    public void load(List<GirlsBean.ResultsEntity> datas) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNormal() {

    }
}
