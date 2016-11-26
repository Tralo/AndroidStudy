package com.study.pg.girl;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.study.pg.R;
import com.study.pg.base.AppActivity;
import com.study.pg.base.BaseFragment;
import com.study.pg.util.ColorUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adventurer on 16-11-26.
 */

public class GirlActivity extends AppActivity implements GirlFragment.OnGirlChange{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    GirlFragment mGirlFragment;

    @Override
    protected BaseFragment getFirstFragment() {
        mGirlFragment = GirlFragment.newInstance(getIntent().getParcelableArrayListExtra("girls"),
                getIntent().getIntExtra("current",0));
        return mGirlFragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mToolbar.setTitle(R.string.meizhi);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.ic_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_girl,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            mGirlFragment.shareGirl();
            return true;
        } else if (id == R.id.action_save) {
            mGirlFragment.saveGirl();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_girl;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.girl_fragment;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void change(int color) {
        mToolbar.setBackgroundColor(color);
        if(Build.VERSION.SDK_INT >= 21){
            Window window = getWindow();
            window.setStatusBarColor(ColorUtil.colorBurn(color));
            window.setNavigationBarColor(ColorUtil.colorBurn(color));
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finishActivity();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }

    private void finishActivity() {
        finish();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }
}
