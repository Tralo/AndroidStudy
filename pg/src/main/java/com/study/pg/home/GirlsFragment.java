package com.study.pg.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewStub;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.study.pg.R;
import com.study.pg.base.BaseFragment;
import com.study.pg.data.bean.GirlsBean;
import com.study.pg.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by adventurer on 16-11-25.
 */

public class GirlsFragment extends BaseFragment implements GirlsContract.View, SwipeRefreshLayout.OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener {
    public static final String TAG = "GirlsFragment";

    @BindView(R.id.girls_recycler_view)
    EasyRecyclerView mGirlsRecyclerView;

    @BindView(R.id.network_error_layout)
    ViewStub mNetworkErrorLayout;

    private View networkErrorView;

    private ArrayList<GirlsBean.ResultsEntity> data;
    private GirlsAdapter mAdapter;

    private GirlsPresenter mPresenter;

    private int page = 1;
    private int size = 20;

    private Unbinder unbinder;

    public static GirlsFragment getInstance(){
        GirlsFragment mainFragment = new GirlsFragment();
        return mainFragment;
    }




    @Override
    public void onRefresh() {
        mPresenter.getGirls(1, size, true);
        page = 1;
    }

    @Override
    public void onLoadMore() {
        if (data.size() % 20 == 0) {
            LogUtil.d(TAG, "onloadmore");
            page++;
            mPresenter.getGirls(page, size, false);
        }
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this,view);
        mPresenter = new GirlsPresenter(this);
        initRecyclerView();
        //初始化数据
        mPresenter.start();

    }

    private void initRecyclerView() {
        data = new ArrayList<>();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        mGirlsRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        mAdapter = new GirlsAdapter(getContext());

        mGirlsRecyclerView.setAdapterWithProgress(mAdapter);

        mAdapter.setMore(R.layout.load_more_layout,this);
        mAdapter.setNoMore(R.layout.no_more_layout);
        mAdapter.setError(R.layout.error_layout);
        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Intent intent = new Intent(mActivity,GirlActivity.class);

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void refresh(List<GirlsBean.ResultsEntity> datas) {
        data.clear();
        data.addAll(datas);
        mAdapter.clear();
        mAdapter.addAll(datas);
    }

    @Override
    public void load(List<GirlsBean.ResultsEntity> datas) {
        data.addAll(datas);
        mAdapter.addAll(datas);
    }

    @Override
    public void showError() {
        mGirlsRecyclerView.showError();
        if(networkErrorView != null){
            networkErrorView.setVisibility(View.VISIBLE);
            return;
        }
        networkErrorView = mNetworkErrorLayout.inflate();

    }

    @Override
    public void showNormal() {
        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.GONE);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
