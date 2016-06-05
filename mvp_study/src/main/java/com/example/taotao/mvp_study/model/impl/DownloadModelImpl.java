package com.example.taotao.mvp_study.model.impl;

import android.os.Message;

import com.example.taotao.mvp_study.model.IDownloadModel;

/**
 * Created by taotao on 16-5-30.
 */

public class DownloadModelImpl implements IDownloadModel {


    /**
     * 下载回调接口
     */
    public interface DownloadListener{
        void startDownload();//开始下载回调
        void downloading(int process);//下载过程回调
        void finishDownload();//完成下载回调
    }

    @Override
    public void startDownload(final DownloadListener listener) {
        if(listener != null){
            listener.startDownload();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                int process = 5;
                while(process <= 100){
                    listener.downloading(process);

                    process += 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                listener.finishDownload();
            }
        }).start();
    }
}
