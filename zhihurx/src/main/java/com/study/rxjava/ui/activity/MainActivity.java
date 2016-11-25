package com.study.rxjava.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.study.rxjava.R;
import com.study.rxjava.bean.Story;
import com.study.rxjava.ui.adapter.StoriesAdapter;
import com.study.rxjava.ui.contract.MainContract;
import com.study.rxjava.ui.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View,View.OnClickListener{


    private MainPresenter presenter ;
    private StoriesAdapter adapter;

    private List<Story> storyList = new ArrayList<Story>();
    private Context context;

    private ProgressBar progressBar;
    private Button btnByRR;
    private Button btnByVolley;
    private Button btnClear;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initView();


        presenter = new MainPresenter(this,storyList,this);
    }

    private void initView() {
        btnByRR = (Button) findViewById(R.id.btn_RxJava);
        btnByVolley = (Button) findViewById(R.id.btn_volley);
        btnClear = (Button) findViewById(R.id.btn_clear);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnByRR.setOnClickListener(this);
        btnByVolley.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        adapter = new StoriesAdapter(this,storyList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorMeg(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId){
            case R.id.btn_RxJava:

                adapter.setGetPicByRR(true);
                presenter.getDataByRetrofit();
                break;
            case R.id.btn_clear:
                storyList.clear();
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_volley:
                adapter.setGetPicByRR(false);
                presenter.getDataByVolley();
                break;
        }

    }
}
