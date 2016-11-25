package com.study.demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReposListActivity extends BaseActivity {
    @Bind(R.id.rv)
    RecyclerView rv;

    @Bind(R.id.pb)
    ProgressBar pb;

    @Inject
    GithubApiService githubApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        ListAdapter adapter = new ListAdapter();
        rv.setAdapter(adapter);
        loadData(adapter);
    }

    private void loadData(final ListAdapter adapter) {
        showLoading(true);
        githubApiService.getRepoData(getUser()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SimpleObserver<ArrayList<Repo>>() {
            @Override
            public void onNext(ArrayList<Repo> repos) {
                showLoading(false);
                adapter.setRepos(repos);
            }

            @Override
            public void onError(Throwable e) {
                showLoading(false);
            }
        });
    }


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    private String getUser() {
        return "bird1015";
    }

    public void showLoading(boolean loading) {
        Log.i("info", loading + " Repos");
        pb.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_repos_list;
    }
}
