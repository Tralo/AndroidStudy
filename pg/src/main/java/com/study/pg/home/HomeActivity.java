package com.study.pg.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.study.pg.R;
import com.study.pg.about.AboutActivity;
import com.study.pg.base.AppActivity;
import com.study.pg.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**mv
 * Created by adventurer on 16-11-20.
 */

public class HomeActivity extends AppActivity{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private long exitTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.action_about:
                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return new GirlsFragment();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.girls_fragment;
    }

    @OnClick(R.id.fab)
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.fab:
                // 必须明确使用 mailto前缀来修饰邮件地址，如果使用
                Uri uri = Uri.parse("mailto:a@a.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                startActivity(Intent.createChooser(intent,"请选择邮件类应用"));

                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            //两秒之内按返回键就会退出
            if((System.currentTimeMillis() - exitTime) > 2000){
                Snackbar.make(mFab,"再按一次推出程序哦",Snackbar.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
