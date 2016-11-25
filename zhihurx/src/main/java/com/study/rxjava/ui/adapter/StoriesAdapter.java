package com.study.rxjava.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.study.rxjava.R;
import com.study.rxjava.bean.Story;
import com.study.rxjava.network.RetrofitManager;
import com.study.rxjava.network.VolleyManager;
import com.study.rxjava.network.inter.GetBitmap;

import java.util.List;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/25.
 */

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyViewHolder> {

    private List<Story> storyList;

    private Context context;
    private boolean getPicByRR = true;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stories_show_card,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.tvTitle.setText(story.getTitle());
        if(getPicByRR){
            //get pic by Retrofit and RxJava
            Action1<Bitmap> bitmapAction1 = new Action1<Bitmap>() {
                @Override
                public void call(Bitmap bitmap) {
                    holder.ivImg.setImageBitmap(bitmap);
                }
            };
            GetBitmap getBitmap = RetrofitManager.getInstance().getRetrofit().create(GetBitmap.class);
            getBitmap
                    .getPicFromNet(story.getImages().get(0))
                    .map(new Func1<ResponseBody, Bitmap>() {

                        @Override
                        public Bitmap call(ResponseBody responseBody) {
                            return BitmapFactory.decodeStream(responseBody.byteStream());
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(bitmapAction1);
        } else {
            ImageLoader imageLoader = new ImageLoader(VolleyManager.getInstance().getRequestQueue(context.getApplicationContext())
                    , new ImageLoader.ImageCache() {
                @Override
                public Bitmap getBitmap(String url) {
                    return null;
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {

                }
            });
            ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(holder.ivImg, R.mipmap.ball, R.mipmap.ball);
            imageLoader.get(story.getImages().get(0), imageListener);
        }


    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView ivImg;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivImg = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }

    public StoriesAdapter(Context context, List<Story> storiesList) {
        this.storyList = storiesList;
        this.context = context;
    }

    public void setGetPicByRR(boolean b) {
        this.getPicByRR = b;
    }


}
