package com.study.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick(R.id.id_main_button)
    public void onShowRepositoriesClick() {
        startActivity(new Intent(this, ReposListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId(){
        return R.layout.activity_main;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent){

    }
}
