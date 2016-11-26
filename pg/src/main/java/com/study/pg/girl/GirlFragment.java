package com.study.pg.girl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.study.pg.R;
import com.study.pg.app.Constants;
import com.study.pg.base.BaseFragment;
import com.study.pg.data.bean.GirlsBean;
import com.study.pg.home.GirlsFragment;
import com.study.pg.util.BitmapUtil;
import com.study.pg.widget.PinchImageView;

import java.io.File;
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

    public static GirlFragment newInstance(ArrayList<Parcelable> datas, int current){
        Bundle bundle = new Bundle();
        GirlFragment fragment = new GirlFragment();
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
        getColor();

    }

    private void getColor() {
        PinchImageView imageView = getCurrentImageView();
        Bitmap bitmap = BitmapUtil.drawableToBitmap(imageView.getDrawable());
        Palette.Builder builder = Palette.from(bitmap);
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vir = palette.getVibrantSwatch();
                if(vir == null){
                    return;
                }
                mListener.change(vir.getRgb());
            }
        });
    }

    public void saveGirl(){
        String imgUrl = datas.get(mViewPager.getCurrentItem()).getUrl();
        PinchImageView imageView = getCurrentImageView();
        Bitmap bitmap = BitmapUtil.drawableToBitmap(imageView.getDrawable());
        boolean isSuccess = BitmapUtil.saveBitmap(bitmap,
                Constants.dir,imgUrl.substring(imgUrl.lastIndexOf("/") + 1, imgUrl.length()),true);
        if(isSuccess){
            Snackbar.make(rootView, "大爷，下载好了呢~", Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(rootView, "大爷，下载出错了哦~", Snackbar.LENGTH_LONG).show();
        }
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

    public void shareGirl() {
        PinchImageView imageView = getCurrentImageView();
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            Bitmap bitmap = BitmapUtil.drawableToBitmap(drawable);
            boolean isSuccess = BitmapUtil.saveBitmap(bitmap, Constants.dir, "share.jpg", false);
            if (isSuccess) {
                //由文件得到uri
                Uri imageUri = Uri.fromFile(new File(Constants.dir + "/share.jpg"));
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.setType("image/*");
                startActivity(Intent.createChooser(shareIntent, "分享MeiZhi到"));
            } else {
                Snackbar.make(rootView, "大爷，分享出错了哦~", Snackbar.LENGTH_LONG).show();
            }
        }
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
